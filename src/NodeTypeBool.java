public class NodeTypeBool extends Node{

public NodeTypeBool()
{
}

public NodeTypeBool(Token token_)
{
  token = token_;
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeBool) && !(otherNode instanceof NodeExpressionConstBoolean))
  {
    throw new TypeCheckingException();
  }
  return true;
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("No code generation for type nodes");
}

public String toString(String indendation)
{
  return "boolean";
}
}
