public class NodeExpressionUnaryBitwiseNegation extends NodeExpressionUnary{

public NodeExpressionUnaryBitwiseNegation(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionUnaryBitwiseNegation))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionUnaryBitwiseNegation)otherNode);
}

public String toString(String indendation)
{
  return "~" + innerNode.toString(indendation);
}

}
