package src;

import src.bin.*;

public class NodeExpressionSum extends NodeExpressionBinary{

public NodeExpressionSum(Node primary_)
{
  super(primary_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionSum))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionSum)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public String emitCode() throws CodeGenerationException
{
  String result = super.emitCode();
  result += (op == "+" ? "add\n": "sub\n");
  return result;
}

public boolean checkNodeType() throws TypeCheckingException
{
  return primary.getNodeType().compareNodeType(new NodeTypeInt()) && secondary.getNodeType().compareNodeType(new NodeTypeInt()) && primary.checkNodeType() && secondary.checkNodeType();
}
}
