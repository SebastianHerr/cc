package src;

import src.bin.*;

public class NodeExpressionEquality extends NodeExpressionBinary{

public NodeExpressionEquality(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionEquality))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionEquality)otherNode);
}

public NodeType getNodeType()
{
  return new NodeTypeBool();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  if(op == "!=")
  {
    result += "neq\n";
  }
  else
  {
    result += "eq\n";
  }
  return result;
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  //Both sides need to be the same, no further restriction
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}
}
