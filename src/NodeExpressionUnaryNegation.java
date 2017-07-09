public class NodeExpressionUnaryNegation extends NodeExpressionUnary{

public NodeExpressionUnaryNegation(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionUnaryNegation))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionUnaryNegation)otherNode);
}

public String toString(String indendation)
{
  return "!" + innerNode.toString(indendation);
}
}
