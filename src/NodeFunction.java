import java.util.*;
public class NodeFunction extends Node implements IScope{

Node type;
Node name;
NodeFunctionParamArgs params;

NodeBlock nodeFunctionCode;

int scopeID;

  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeFunction(Node type_, Node name_)
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
return "NodeFunction";
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

public void setFunctionCodeBlock(NodeBlock nodeFunctionCode_)
{
  nodeFunctionCode = nodeFunctionCode_;
  nodeFunctionCode.setParent(this);
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
  if(nodeFunctionCode == null)
  {
    result += ";\n";
  }
  else
  {
     result += "\n" + nodeFunctionCode.toString(indendation);
  }
  return result;
}
}
