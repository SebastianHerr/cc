public class NodeExpressionLogicalOr extends NodeExpressionBinary{

public NodeExpressionLogicalOr(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionLogicalOr))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionLogicalOr)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeBool();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  result += "or\n";
  return result;
}

public boolean checkNodeType() throws TypeCheckingException
{
  return primary.compareNodeType(new NodeTypeBool()) && secondary.compareNodeType(new NodeTypeBool()) && primary.checkNodeType() && secondary.checkNodeType();
}
}
