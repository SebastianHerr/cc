public class NodeExpressionVariableDefinition extends Node{

Node type;
Node name;

public NodeExpressionVariableDefinition(Node type_, Node name_)
{
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
}

public String getNodeType()
{
return "NodeExpressionVariableDefinition";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return type + " " + name;
}

}
