public class NodeExpressionUnaryMinus extends NodeExpressionUnary{

public NodeExpressionUnaryMinus(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionUnaryMinus))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionUnaryMinus)otherNode);
}

public String toString(String indendation)
{
  return "-" + innerNode.toString(indendation);
}
}
