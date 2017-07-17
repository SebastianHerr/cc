public class NodeExpressionCompare extends NodeExpressionBinary{

public NodeExpressionCompare(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionCompare))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionCompare)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeBool();
}
}
