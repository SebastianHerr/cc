public class NodeExpressionUnaryDereference extends NodeExpressionUnary{

public NodeExpressionUnaryDereference(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionUnaryDereference))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionUnaryDereference)otherNode);
}

public String toString(String indendation)
{
  return "*" + innerNode.toString(indendation);
}
}
