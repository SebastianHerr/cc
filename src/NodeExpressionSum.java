public class NodeExpressionSum extends NodeExpressionBinary{

public NodeExpressionSum(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionSum))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionSum)otherNode);
}
}
