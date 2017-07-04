import java.util.*;
public class SymbolTable{
  
  private class Symbol{
    public ArrayList<IScope> scopes;
    public ArrayList<NodeIdentifier> symbolNodes;
    public int symbolID;
    public String image;
    public Symbol(IScope scope,NodeIdentifier symbol, int symbolID_)
    {
      scopes = new ArrayList<IScope>();
      symbolNodes = new ArrayList<NodeIdentifier>();
      symbolID = symbolID_;
      image = symbol.getToken().image;
      addAppearance(scope,symbol);
    }
    
    public void addAppearance(IScope scope,NodeIdentifier symbol)
    {
      scopes.add(scope);
      symbolNodes.add(symbol);
    }
    
     public String toString()
     {
       String aredefs = "";
       for(NodeIdentifier node : symbolNodes)
       {
          aredefs+=(node.isVariableDefinition() ? "VY":"VN");
          aredefs+=(node.isFunctionDefinition() ? "FY":"FN");
          aredefs+=" ";
       }
       return symbolID + "\t\"" + symbolNodes.get(0) + "\" ISDEF="+ aredefs;
     }
  }
  

  static int nextScopeID = 0; 
  public static int getNextScopeID()
  {
    return nextScopeID++;
  }
  
  
  int nextSymbolID = 0;
  LinkedHashMap<String, Symbol> symbols;
  
  public SymbolTable()
  {
    symbols = new LinkedHashMap<String,Symbol>();
  }
  
  public void printStats()
  {
    System.out.println("Seen " + nextSymbolID + " Symbols in " + nextScopeID + " Scopes");
    for (Map.Entry<String, Symbol> entry : symbols.entrySet()) 
    {
      String key = entry.getKey();
      Symbol value = entry.getValue();

      System.out.println ("\tKey: " + key + "\t\tValue: " + value);
    }
  }
  
  /*
   * Returns the Node which is a definition of a variable or function
   */
  private NodeIdentifier getDefinitionNodeInScope(IScope scope, String image, int id)
  {
    //System.out.println("Searching \"" + image + "\" with the ID " + id +" starting in scope " + scope.getScopeID());
    while(scope.getListOfVidDefines().get(image) == null)
    {
      scope = ((Node)scope).getParent().getContainingScope();
      //If the scope is now null, then we reached the root and the image is not defined
      if(((Node)scope).isRoot())
      {
         //System.out.println("\tReached the root, variable not yet defined");
        return null;
      }
      else
      {
        //System.out.println("\tNot yet found, going up to scope " + scope.getScopeID());
      }
    }
    //System.out.println("\tFound the image in scope " + scope.getScopeID());
    return scope.getListOfVidDefines().get(image);
  }

  /*
   * returns 0 if all is okay
   * returns 10 if a function is defined twice
   * returns 15 if a function is undefined
   * returns 16 if a function is declared but undefined
   * returns 20 if a variable is defined twice
   * returns 25 if a variable is undefined
   * returns 30 if a symbol is used ot define a function and variable
   */
  public int addSymbolToScopeNodes(Symbol symbol)
  {
    //System.out.println("Linking Symbol " + symbol.symbolID + " which has " + symbol.symbolNodes.size() + " Nodes");
    NodeRoot root = symbol.symbolNodes.get(0).getRoot();
    Hashtable<String, NodeIdentifier> functionDefines = root.getListOfVidDefines();
    Stack<Integer> funcUsages = new Stack<Integer>();
    for(int i = 0; i<symbol.symbolNodes.size();i++)
    {
      boolean isLastSymbol = i == symbol.symbolNodes.size() - 1;
      NodeIdentifier node = symbol.symbolNodes.get(i);
      IScope scope = symbol.scopes.get(i);
      
      //System.out.println("New round with " + node.isVariableDefinition() + "" + node.isFunctionDefinition());
      
      
      //definition of Variable
      if(node.isVariableDefinition() && !node.isFunctionDefinition())
      {
        if(getDefinitionNodeInScope(scope, node.getToken().image, symbol.symbolID) != null)
        {
          //System.out.println("Variable with Symbol  \"" + node.getToken().image + "\" and ID " + symbol.symbolID + " already defined");
          return 20;
        }
        else
        {
          //System.out.println("Variable defintion of Symbol " + symbol.symbolID + " adding to scope " + scope.getScopeID());
          scope.getListOfVidDefines().put(node.getToken().image,node);
          ((Node)scope).getParent().getContainingScope().addSubscope(scope);
        }
      }
      //definition or declaration of a function
      else if(!node.isVariableDefinition() && node.isFunctionDefinition())
      {
        //Information of the already saved node
        Node functionName = functionDefines.get(node.getToken().image);
        
        if(functionName != null)
        {
          NodeFunction functionNode = (NodeFunction)functionName.getParent();
          //Information about the new node
          NodeFunction newFunctionNode = (NodeFunction)node.getParent();
          
          /*
           * If there are only declarions with the same types then it's okay, this is checked in the type checking stage.
           * There can be at most one function definition.
           */
          if(functionNode.isDefined() && newFunctionNode.isDefinition())
          {
            System.out.println("Function with Symbol \"" + node.getToken().image + "\"" + node.getOccouranceLocation() +  " and ID " + symbol.symbolID + " already defined");
            return 10;
          }
          
          /*
           * Link all the declations together in a linked list. If the first definition is found link all to this definition.
           * When there are no further declarations/definitions with this symbol, then check if a function definition has been supplied.
           * If there isn't a definition, then return with an error.
           */
          if( functionNode.isDefined() && !newFunctionNode.isDefinition())
          {
            //System.out.println("\t\tLinking to definition node " + functionName);
            newFunctionNode.setFunctionLink(functionNode.getFunctionLink());
          }
          else if( !functionNode.isDefined() && !newFunctionNode.isDefinition())
          {
            //System.out.println("\t\tLinking to previous node " + functionName);
            newFunctionNode.setFunctionLink(functionNode);
            if(isLastSymbol)
            {
              System.out.println("The function " + node + " has been declared, but not yet defined");
              return 16;
            }
          }
          else if( !functionNode.isDefined() && newFunctionNode.isDefinition())
          {
            //System.out.println("\t\tRelinking all nodes to the definition " + functionName);
            //Traverse the list and replace all functionLinks with a new link to the new definition
            NodeFunction tmpLink = functionNode;
            NodeFunction tmpLink2;
            do
            {
              tmpLink2 = tmpLink.getFunctionLink();
              tmpLink.setFunctionLink(newFunctionNode);
              tmpLink = tmpLink2;
            }
            while( tmpLink!= null);
          }
        }
        else
        {
          if(isLastSymbol && !((NodeFunction)node.getParent()).isDefinition())
          {
            System.out.println("The function " + node + " has been declared, but not yet defined");
            return 16;
          }
          //System.out.println("Funtion defintion of Symbol " + symbol.symbolID + " adding to root scope " + scope.getScopeID());
          functionDefines.put(node.getToken().image,node);
        }
      }
      //usage as function call or variable access
      else if(!node.isVariableDefinition() && !node.isFunctionDefinition())
      {
        System.out.println("Usage of \"" + node.getToken().image + "\" and start searching for definition in " + scope.getScopeID());
        
        if(node.isFunctionCall())
        {
          //Manage all the function after the definitions have been put in place.
          funcUsages.push(i);
        }
        else
        {
           //But check variable usages here, otherwise "i = 5; int i;" could happen
           NodeIdentifier definitionName = getDefinitionNodeInScope(scope, node.getToken().image, symbol.symbolID);
           if(definitionName==null)
           {
             System.out.println("Variable " + node.getToken().image + " at location " + node .getOccouranceLocation() + " is used without beinging defined first");
             return 25;
           }
           definitionName.addUsage(node);
           ((Node)scope).getParent().getContainingScope().addSubscope(scope);
        }
      }
      //Some kind of error, for example if a variable is used to define a function and variable
      else
      {
        //System.out.println("Symbol " + symbol.symbolID + " can't be used to define a function and a variable");
        return 30;
      }
    }
    
    //Link the usages of fucntions to their definition
    while(!funcUsages.empty() && funcUsages.peek() != null)
    {
      int currentIndex = funcUsages.pop();
        System.out.println(currentIndex);
      NodeIdentifier node = symbol.symbolNodes.get(currentIndex);
        System.out.println(node);
      Node definitionName = functionDefines.get(node.getToken().image);
        System.out.println(definitionName);
      if(definitionName == null)
      {
        System.out.println("The function " + node + " which was called has never been defined");
        return 15;
      }
      NodeFunction definition = (NodeFunction)definitionName.getParent();
        System.out.println(definition);
      node.setDefintion(definition.getName());
    }
    
    return 0;
  }
  
  public int addAllSymbolsToScopeNodes()
  {
    for (Map.Entry<String, Symbol> entry : symbols.entrySet()) 
    {
      //System.out.println("Adding new " + entry.getValue().image);
      int symbolLinker = addSymbolToScopeNodes(entry.getValue());
      if(symbolLinker != 0)
      {
        //System.out.println("Aborted with " + symbolLinker);
        return symbolLinker;
      }
    }
    return 0;
  }
    
  //Adds the symbol if it's not present and returns true, does nothing otherwise and returns false
  public boolean addSymbol(NodeIdentifier symbol, IScope scope)
  {
    boolean returnValue;
    String symbolImage = symbol.getToken().image;
    Symbol symbolFromTable = symbols.get(symbolImage);
    if(symbolFromTable != null)
    {
      symbolFromTable.addAppearance(scope,symbol);
      //System.out.println("Seen  Symbol \"" + symbolImage + "\"\t with ID " + symbolFromTable.symbolID + " in scope " + scope.getScopeID());
      symbol.setSymbolID(symbolFromTable.symbolID);
      returnValue = false;
    }
    else
    {
      symbolFromTable =  new Symbol(scope,symbol, nextSymbolID);
      symbols.put(symbolImage, symbolFromTable);
      symbol.setSymbolID(symbolFromTable.symbolID);
      //System.out.println("Added Symbol \"" + symbol + "\" in scope " + scope.getScopeID());
      returnValue = true;
      nextSymbolID++;
    }
    return returnValue;
  }
}