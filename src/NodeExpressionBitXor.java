public class NodeExpressionBitXor extends NodeExpressionBinary{

public NodeExpressionBitXor(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBitXor))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return super.compareNodeType((NodeExpressionBitXor)otherNode);
}
}
