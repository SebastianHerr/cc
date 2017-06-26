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
  Hashtable<String, Symbol> symbols;
  
  public SymbolTable()
  {
    symbols = new Hashtable<String,Symbol>();
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
  
  private boolean isDefinedInScope(IScope scope, String image, int id)
  {
    //System.out.println("Searching \"" + image + "\" with the ID " + id +" starting in scope " + scope.getScopeID());
    while(scope.getListOfVidDefines().get(image) == null)
    {
      scope = scope.getParent().getContainingScope();
      //If the scope is now null, then we reached the root and the image is not defined
      if(scope == null)
      {
         //System.out.println("\tReached the root, variable not yet defined");
        return false;
      }
      else
      {
        //System.out.println("\tNot yet found, going up to scope " + scope.getScopeID());
      }
    }
    //System.out.println("\tFound the image in scope " + scope.getScopeID());
    return true;
  }

  /*
   * returns 0 if all is okay
   * returns 10 if a function is defined twice
   * returns 15 if a function is undefined
   * returns 20 if a variable is defined twice
   * returns 25 if a variable is undefined
   * returns 30 if a symbol is used ot define a function and variable
   */
  public int addSymbolToScopeNodes(Symbol symbol)
  {
    //System.out.println("Linking Symbol " + symbol.symbolID + " which has " + symbol.symbolNodes.size() + " Nodes");
    NodeRoot root = symbol.symbolNodes.get(0).getRoot();
    Hashtable<String, NodeIdentifier> functionDefines = root.getListOfVidDefines();
    for(int i = 0; i<symbol.symbolNodes.size();i++)
    {
      NodeIdentifier node = symbol.symbolNodes.get(i);
      IScope scope = symbol.scopes.get(i);
      
      //System.out.println("New round with " + node.isVariableDefinition() + "" + node.isFunctionDefinition());
      
      
      //definition of Variable
      if(node.isVariableDefinition() && !node.isFunctionDefinition())
      {
        if(isDefinedInScope(scope, node.getToken().image, symbol.symbolID))
        {
          //System.out.println("Variable with Symbol  \"" + node.getToken().image + "\" and ID " + symbol.symbolID + " already defined");
          return 20;
        }
        else
        {
          //System.out.println("Variable defintion of Symbol " + symbol.symbolID + " adding to scope " + scope.getScopeID());
          scope.getListOfVidDefines().put(node.getToken().image,node);
        }
      }
      //definition of Function
      else if(!node.isVariableDefinition() && node.isFunctionDefinition())
      {
        if(functionDefines.containsKey(node.getToken().image))
        {
          //System.out.println("Funtion with Symbol \"" + node.getToken().image + "\" and ID " + symbol.symbolID + " already defined");
          return 10;
        }
        else
        {
          //System.out.println("Funtion defintion of Symbol " + symbol.symbolID + " adding to root scope " + scope.getScopeID());
          functionDefines.put(node.getToken().image,node);
        }
      }
      //usage as function call or variable access
      else if(!node.isVariableDefinition() && !node.isFunctionDefinition())
      {
         //System.out.println("Usage of " + symbol.symbolID + " and start searching for definition in " + scope.getScopeID());
      }
      //Some kind of error, for example if a variable is used to define a function and variable
      else
      {
        //System.out.println("Symbol " + symbol.symbolID + " can't be used to define a function and a variable");
        return 30;
      }
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