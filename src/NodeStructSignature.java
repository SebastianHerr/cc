import java.util.*;
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

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  //No functions and variables can be defined inside a struct, caller needs to check for null
  return null;
}

public IScope getContainingScope()
{
  return this;
}

public String toString(String indendation)
{
  return "struct " + name.toString(indendation) + " /* Scope ID = " +  scopeID + " */";
}
}
