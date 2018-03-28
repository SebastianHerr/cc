package src;

import src.bin.*;

public class NodeExpressionBitXor extends NodeExpressionBinary{

public NodeExpressionBitXor(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionBitXor))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionBitXor)otherNode);
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
  result += "bxor\n";
  return result;
}

public Node getNodeType()
{
  return new NodeTypeInt();
}
}
