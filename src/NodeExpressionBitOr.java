public class NodeExpressionBitOr extends NodeExpressionBinary{

public NodeExpressionBitOr(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBitOr))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionBitOr)otherNode);
}
}
