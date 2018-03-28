package src;

import src.bin.*;

public class NodeExpressionLogicalAnd extends NodeExpressionBinary{

public NodeExpressionLogicalAnd(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionLogicalAnd))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionLogicalAnd)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeBool();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  result += "and\n";
  return result;
}

public boolean checkNodeType() throws TypeCheckingException
{
  return primary.compareNodeType(new NodeTypeBool()) && secondary.compareNodeType(new NodeTypeBool()) && primary.checkNodeType() && secondary.checkNodeType();
}
}
