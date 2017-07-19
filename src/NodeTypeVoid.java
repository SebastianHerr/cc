public class NodeTypeVoid extends Node{

public NodeTypeVoid()
{
}

public NodeTypeVoid(Token token_)
{
  token = token_;
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeVoid))
  {
    throw new TypeCheckingException();
  }
  else
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
  return "void";
}
}
