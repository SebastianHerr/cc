import java.util.*;
public class SymbolTable{
  
  private class Symbol{
    public ArrayList<Integer> scope;
    public ArrayList<NodeIdentifier> symbol;
    public int symbolID;
    public Symbol(IScope scope_,NodeIdentifier symbol_, int symbolID_)
    {
      scope = new ArrayList<Integer>();
      symbol = new ArrayList<NodeIdentifier>();
      symbolID = symbolID_;
      addAppearance(scope_,symbol_);
    }
    
    public void addAppearance(IScope scope_,NodeIdentifier symbol_)
    {
      scope.add(scope_.getScopeID());
      symbol.add(symbol_);
    }
    
     public String toString()
     {
       String aredefs = "";
       for(NodeIdentifier node : symbol)
       {
          aredefs+=(node.isVariableDefinition() ? "VY":"VN");
          aredefs+=(node.isFunctionDefinition() ? "FY":"FN");
          aredefs+=" ";
       }
       return symbolID + "\t\"" + symbol.get(0) + "\" ISDEF="+ aredefs + "\t" + scope;
     }
  }
  
  int nextSymbolID = 0;

  static int nextScopeID = 0; 
  public static int getNextScopeID()
  {
    return nextScopeID++;
  }
  
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

    
  //Adds the symbol if it's not present and returns true, does nothing otherwise and returns false
  public boolean addSymbol(NodeIdentifier symbol, IScope scope)
  {
    boolean returnValue;
    String symbolImage = symbol.getToken().image;
    Symbol symbolFromTable = symbols.get(symbolImage);
    if(symbolFromTable != null)
    {
      symbolFromTable.addAppearance(scope,symbol);
      System.out.println("Seen  Symbol \"" + symbolImage + "\"\t with ID " + symbolFromTable.symbolID + " in scope " + scope.getScopeID());
      symbol.setSymbolID(symbolFromTable.symbolID);
      returnValue = false;
    }
    else
    {
      symbolFromTable =  new Symbol(scope,symbol, nextSymbolID);
      symbols.put(symbolImage, symbolFromTable);
      symbol.setSymbolID(symbolFromTable.symbolID);
      System.out.println("Added Symbol \"" + symbol + "\" in scope " + scope.getScopeID());
      returnValue = true;
      nextSymbolID++;
    }
    return returnValue;
  }
}