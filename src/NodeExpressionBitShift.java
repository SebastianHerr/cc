public class NodeExpressionBitShift extends NodeExpressionBinary{

public NodeExpressionBitShift(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionBitShift))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionBitShift)otherNode);
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  //Both sides need to be the same, and both need to be integers
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())) && primary.getNodeType().compareNodeType(new NodeTypeInt()))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("Not implemented");
}

public Node getNodeType()
{
  return new NodeTypeInt();
}
}
