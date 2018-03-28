package src;

import src.bin.*;

public class NodeExpressionCompare extends NodeExpressionBinary{

public NodeExpressionCompare(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionCompare))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionCompare)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeBool();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  switch(op)
  {
    case "<":
      result += "le\n";
      break;
    case ">":
      result += "gr\n";
      break;
    case "<=":
      result += "leq\n";
      break;
    case ">=":
      result += "geq\n";
      break;
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
