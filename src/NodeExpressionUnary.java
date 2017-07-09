public abstract class NodeExpressionUnary extends Node{

Node innerNode;

public NodeExpressionUnary()
{
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionUnary))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return innerNode.compareNodeType(((NodeExpressionUnary)otherNode).innerNode);
}

public void setInternNode(Node innerNode_)
{
  innerNode = innerNode_;
  innerNode.setParent(this);
}

}
