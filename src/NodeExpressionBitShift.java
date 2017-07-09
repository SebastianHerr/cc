public class NodeExpressionBitShift extends NodeExpressionBinary{

public NodeExpressionBitShift(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBitShift))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionBitShift)otherNode);
}
}
