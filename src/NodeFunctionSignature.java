import java.util.*;
public class NodeFunctionSignature extends Node implements IScope{

Node type;
Node name;
ArrayList<Node> listOfParamters;
int scopeID;

public NodeFunctionSignature(Node type_, Node name_)
{
  scopeID = SymbolTable.getNextScopeID();
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
  listOfParamters = new ArrayList<Node>();
}

public String getNodeType()
{
return "NodeFunctionSignature";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addParameter(Node parameterType, Node parameterName)
{
  parameterType.setParent(this);
  parameterName.setParent(this);
  listOfParamters.add(parameterType);
  listOfParamters.add(parameterName);
}

public int getScopeID()
{
  return scopeID;
}

public String toString(String indendation)
{
  String result = type + " " + name + "(";
  for(int i = 0; i < listOfParamters.size(); i += 2) {
    if(i!=0) {
      result += ",";
    }
    result+= listOfParamters.get(i) + " " + listOfParamters.get(i+1);
   }
  result += ") /* Scope ID = " +  scopeID + " */";
  return result;
}
}
