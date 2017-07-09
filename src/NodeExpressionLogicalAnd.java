public class NodeExpressionLogicalAnd extends NodeExpressionBinary{

public NodeExpressionLogicalAnd(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionLogicalAnd))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionLogicalAnd)otherNode);
}
}
