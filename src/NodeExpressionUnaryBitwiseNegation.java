package src;

import src.bin.*;

public class NodeExpressionUnaryBitwiseNegation extends NodeExpressionUnary{

public NodeExpressionUnaryBitwiseNegation(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionUnaryBitwiseNegation))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionUnaryBitwiseNegation)otherNode);
}

public NodeType getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.compareNodeType(new NodeTypeInt()) && innerNode.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  return innerNode.emitCode() + "neg\n";
}

public String toString(String indendation)
{
  return "~" + innerNode.toString(indendation);
}

}
