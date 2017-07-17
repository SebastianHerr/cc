public class NodeExpressionBitAnd extends NodeExpressionBinary{

public NodeExpressionBitAnd(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBitAnd))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionBitAnd)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}
}
