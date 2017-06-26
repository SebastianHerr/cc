import java.util.*;
public class NodeFunctionSignature extends Node implements IScope{

Node type;
Node name;
NodeFunctionParamArgs params;
int scopeID;

  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeFunctionSignature(Node type_, Node name_)
{
  scopeID = SymbolTable.getNextScopeID();
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
  vidDefineList = new Hashtable<String,NodeIdentifier>();
}

public String getNodeType()
{
return "NodeFunctionSignature";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addParameters(NodeFunctionParamArgs params_)
{
  params = params_;
  params.setParent(this);
}


public int getScopeID()
{
  return scopeID;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  return vidDefineList;
}

public IScope getContainingScope()
{
  return this;
}


public String toString(String indendation)
{
  String result = type + " " + name + "(";
  result += params;
  result += ") /* Scope ID = " +  scopeID + " */";
  return result;
}
}
