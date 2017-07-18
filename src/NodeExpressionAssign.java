public class NodeExpressionAssign extends NodeExpressionBinary{

public NodeExpressionAssign(Node primary_)
{
  super(primary_);
}

public Node getNodeType()
{
  return primary.getNodeType();
}
  
public boolean checkNodeType()
{
  //Both sides need to be the same, no futher conditions
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}
}
