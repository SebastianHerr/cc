public class NodeExpressionDecrement extends Node{

Node innerNode;

public NodeExpressionDecrement(Node innerNode_,Token token_)
{
  token = token_;
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionDecrement))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return innerNode.compareNodeType(((NodeExpressionDecrement)otherNode).innerNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public String toString(String indendation)
{
  return innerNode.toString(indendation) + "--";
}
}
