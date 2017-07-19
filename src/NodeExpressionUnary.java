public abstract class NodeExpressionUnary extends Node{

Node innerNode;

public NodeExpressionUnary()
{
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionUnary))
  {
    throw new TypeCheckingException();
  }
  return innerNode.compareNodeType(((NodeExpressionUnary)otherNode).innerNode);
}

public void setInternNode(Node innerNode_)
{
  innerNode = innerNode_;
  innerNode.setParent(this);
}

}
