package src;

import src.bin.*;

public class NodeExpressionFactor extends NodeExpressionBinary{

public NodeExpressionFactor(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionFactor))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionFactor)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  switch(op)
  {
    case "*":
      result += "mul\n";
      break;
    case "/":
      result += "div\n";
      break;
    case "%":
      result += "mod\n";
      break;
  }
  return result;
}

public boolean checkNodeType() throws TypeCheckingException
{
  return primary.getNodeType().compareNodeType(new NodeTypeInt()) && secondary.getNodeType().compareNodeType(new NodeTypeInt()) && primary.checkNodeType() && secondary.checkNodeType();
}
}
