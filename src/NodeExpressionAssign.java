public class NodeExpressionAssign extends NodeExpressionBinary{

public NodeExpressionAssign(Node primary_)
{
  super(primary_);
}

public Node getNodeType()
{
  return primary.getNodeType();
}
}
