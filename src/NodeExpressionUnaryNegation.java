public class NodeExpressionUnaryNegation extends NodeExpressionUnary{

public NodeExpressionUnaryNegation(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionUnaryNegation))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionUnaryNegation)otherNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.compareNodeType(new NodeTypeBool());
}

public String emitCode() throws CodeGenerationException
{
  return innerNode.emitCode() + "neg\n";
}

public String toString(String indendation)
{
  return "!" + innerNode.toString(indendation);
}
}
