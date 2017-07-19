public class NodeExpressionConstBoolean extends Node{

boolean value;

public NodeExpressionConstBoolean(Token token_, boolean value_)
{
  value = value_;
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeBool) && !(otherNode instanceof NodeExpressionConstBoolean))
  {
    throw new TypeCheckingException();
  }
  return true;
}

public Node getNodeType()
{
  return new NodeTypeBool();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public String emitCode() throws CodeGenerationException
{
  return value ? "1" : "0";
}

public String toString(String indendation)
{
  return value ? "true" : "false";
}
}
