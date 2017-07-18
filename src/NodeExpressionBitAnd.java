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
  
public boolean checkNodeType()
{
  //Both sides need to be the same, and both need to be integers
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())) && primary.getNodeType().compareNodeType(new NodeTypeInt()))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}

public Node getNodeType()
{
  return new NodeTypeInt();
}
}
