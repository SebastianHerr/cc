import java.util.*;
public class SymbolTable{
  
  private class Symbol{
    public IScope scope;
    public Node symbol;
    public int symbolID;
    public Symbol(IScope scope_,Node symbol_, int symbolID_)
    {
      scope = scope_;
      symbol = symbol_;
      symbolID = symbolID_;
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
  }

    
  //Adds the symbol if it's not present and returns true, does nothing otherwise and returns false
  public boolean addSymbol(NodeIdentifier symbol, IScope scope)
  {
    boolean returnValue;
    String symbolImage = symbol.getToken().image;
    Symbol symbolFromTable = symbols.get(symbolImage);
    if(symbolFromTable != null)
    {
      System.out.println("Seen  Symbol " + symbol + " in scope " + scope.getScopeID());
      returnValue = false;
    }
    else
    {
      symbolFromTable =  new Symbol(scope,symbol, nextSymbolID);
      symbols.put(symbolImage, symbolFromTable);
      System.out.println("Added Symbol " + symbol + " in scope " + scope.getScopeID());
      returnValue = true;
      nextSymbolID++;
    }
    symbol.setSymbolID(symbolFromTable.symbolID);
    return returnValue;
  }
}