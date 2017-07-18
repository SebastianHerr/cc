public class NodeExpressionFactor extends NodeExpressionBinary{

public NodeExpressionFactor(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionFactor))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionFactor)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType()
{
  return primary.getNodeType().compareNodeType(new NodeTypeInt()) && secondary.getNodeType().compareNodeType(new NodeTypeInt()) && primary.checkNodeType() && secondary.checkNodeType();
}
}
