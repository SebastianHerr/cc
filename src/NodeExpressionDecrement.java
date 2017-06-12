public class NodeExpressionDecrement extends Node{

Node innerNode;

public NodeExpressionDecrement(Node innerNode_)
{
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public String getNodeType()
{
return "NodeExpressionDecrement";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return innerNode.toString(indendation) + "--";
}
}
