public class NodeExpressionVariableDefinition extends Node{

Node type;
Node name;

public NodeExpressionVariableDefinition(Node type_, Node name_)
{
  type = type_;
  name = name_;
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
