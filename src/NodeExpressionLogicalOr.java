public class NodeExpressionLogicalOr extends NodeExpressionBinary{

public NodeExpressionLogicalOr(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionLogicalOr))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionLogicalOr)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeBool();
}
}
