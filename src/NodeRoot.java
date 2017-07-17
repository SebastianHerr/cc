import java.util.*;
public class NodeRoot extends Node implements IScope{

ArrayList<Node> declarationsOrDefinitions;

int scopeID;
  //Definitions at each scope possible
  SymbolTable vidTable;
  //Definitions only possible at root scope
  SymbolTable sidTable;
  //Definitions only possible inside struct definitions
  SymbolTable fidTable;
  
  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeRoot()
{
  super();
  declarationsOrDefinitions = new ArrayList<Node>();
  scopeID = SymbolTable.getNextScopeID();
  vidDefineList = new Hashtable<String,NodeIdentifier>();
}

public boolean isRoot()
{
  return true;
}

  public NodeRoot getRoot()
  {
    return this;
  }

public void addDeclarationOrDefinition(Node node)
{
  declarationsOrDefinitions.add(node);
  node.setParent(this);
}


public void addSymbolTables(SymbolTable vidTable_, SymbolTable sidTable_, SymbolTable fidTable_)
{
  //Update only new tables
  vidTable = vidTable_ != null ? vidTable_ : vidTable;
  sidTable = sidTable_ != null ? sidTable_ : sidTable;
  fidTable = fidTable_ != null ? fidTable_ : fidTable;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  return vidDefineList;
}

public int getOffsetAfterLocalVidTable()
{
  return 0;
}

public IScope getContainingScope()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeRoot))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  
  boolean returnValue = true;
  for (int i = 0; i<declarationsOrDefinitions.size();i++) {
    returnValue &= declarationsOrDefinitions.get(i).compareNodeType(((NodeRoot)otherNode).declarationsOrDefinitions.get(i)); 
  }
  return returnValue;
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public String toString(String indendation)
{
  String result = "";
  for (Node declarationOrdefinition : declarationsOrDefinitions) {
    result += declarationOrdefinition.toString(indendation); //No identation for the members of the root
  }
  return result;
}

public int getScopeID()
{
  return scopeID;
}
}
