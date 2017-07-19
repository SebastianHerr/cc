public class NodeExpressionConstNull extends Node{

public NodeExpressionConstNull(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionConstNull))
  {
    throw new TypeCheckingException();
  }
  return true;
}

public Node getNodeType()
{
  return new NodeTypePointer();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public String emitCode() throws CodeGenerationException
{
  return "0";
}

public String toString(String indendation)
{
  return "NULL";
}
}
