package src;

import src.bin.*;

public class NodeExpressionUnaryDereference extends NodeExpressionUnary{

public NodeExpressionUnaryDereference(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionUnaryDereference))
  {
    throw new TypeCheckingException();
  }
  return super.compareNodeType((NodeExpressionUnaryDereference)otherNode);
}

public NodeType getNodeType()
{
  return new NodeTypePointer(innerNode);
}

public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  return innerNode.emitCode() + "load\n";
}

public String toString(String indendation)
{
  return "*" + innerNode.toString(indendation);
}
}
