package src;

import src.bin.*;

public class NodeTypeInt extends NodeType{

public NodeTypeInt()
{
}

public NodeTypeInt(Token token_)
{
  token = token_;
}

public NodeType getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeInt || otherNode instanceof NodeExpressionConstNum))
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
  return "int";
}
}
