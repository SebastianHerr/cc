public class NodeExpressionIncrement extends Node{

Node innerNode;

public NodeExpressionIncrement(Node innerNode_, Token token_)
{
  token = token_;
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionIncrement))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return innerNode.compareNodeType(((NodeExpressionIncrement)otherNode).innerNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType()
{
  return innerNode.getNodeType().compareNodeType(new NodeTypeInt()) && innerNode.checkNodeType();
}

public String toString(String indendation)
{
  return innerNode.toString(indendation) + "++";
}
}
