public class NodeExpressionUnaryMinus extends NodeExpressionUnary{

public NodeExpressionUnaryMinus(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionUnaryMinus))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionUnaryMinus)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.compareNodeType(new NodeTypeInt());
}

public String emitCode() throws CodeGenerationException
{
  return "neg \n";
}

public String toString(String indendation)
{
  return "-" + innerNode.toString(indendation);
}
}
