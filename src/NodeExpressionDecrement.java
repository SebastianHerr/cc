public class NodeExpressionDecrement extends Node{

Node innerNode;

public NodeExpressionDecrement(Node innerNode_)
{
  innerNode = innerNode_;
}

public String getNodeType()
{
return "NodeExpressionDecrement";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return innerNode + "--";
}
}
