import java.util.*;
public class NodeFunction extends Node implements IScope{

Node type;
NodeIdentifier name;
NodeFunctionParamArgs params;

NodeBlock nodeFunctionCode;

NodeFunction functionLink;

int scopeID;

  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeFunction(Node type_, NodeIdentifier name_)
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

public Node getName()
{
  return name;
}

public boolean isDefinition()
{
  return nodeFunctionCode != null;
}

public boolean isDefined()
{
  return isDefinition() || (functionLink != null ? functionLink.isDefinition() : false);
}

public void setFunctionLink(NodeFunction functionLink_)
{
  if(isDefined())
  {
    //Should never be reached unless i made a stupid programming mistake :)
    System.out.println("This can only be changed when there isn't already a definition");
  }
  
  functionLink = functionLink_;
}

public NodeFunction getFunctionLink()
{
  if(isDefinition())
  {
    return this;
  }
  else
  {
    return functionLink;
  }
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
