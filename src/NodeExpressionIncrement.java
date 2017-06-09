public class NodeExpressionIncrement extends Node{

Node innerNode;

public NodeExpressionIncrement(Node innerNode_)
{
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public String getNodeType()
{
return "NodeExpressionIncrement";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return innerNode + "++";
}
}
