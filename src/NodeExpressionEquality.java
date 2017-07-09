public class NodeExpressionEquality extends NodeExpressionBinary{

public NodeExpressionEquality(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionEquality))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionEquality)otherNode);
}
}
