public class NodeExpressionBrackets extends Node{

Node node;

public NodeExpressionBrackets(Node node_, Token token_)
{
  node = node_;
  node.setParent(this);
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBrackets))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return node.compareNodeType(((NodeExpressionBrackets)otherNode).node);
}

public String toString(String indentation)
{
  return "(" + node.toString(indentation) + ")";
}

public Node getNodeType()
{
  return node.getNodeType();
}
}
