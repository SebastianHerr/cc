public class NodeStructSignature extends Node implements IScope{

Node name;
int scopeID;

public NodeStructSignature(Node name_)
{
  scopeID = SymbolTable.getNextScopeID();
  name = name_;
  name.setParent(this);
}

public String getNodeType()
{
return "NodeStructSignature";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public int getScopeID()
{
  return scopeID;
}

public String toString(String indendation)
{
  return "struct " + name.toString(indendation) + " /* Scope ID = " +  scopeID + " */";
}
}
