package src;

import src.bin.*;

public class NodeExpressionBitAnd extends NodeExpressionBinary{

public NodeExpressionBitAnd(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionBitAnd))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionBitAnd)otherNode);
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
  String result = super.emitCode();
  result += "band\n";
  return result;
}

public NodeType getNodeType()
{
  return new NodeTypeInt();
}
}
