public class NodeExpressionAlloc extends Node{

Node type;

public NodeExpressionAlloc(Node type_, Token token_)
{
  type = type_;
  token = token_;
  type.setParent(this);
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}

public Node getNodeType()
{
  return new NodeTypePointer(new NodeTypeInt());
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionAlloc))
  {
    throw new TypeCheckingException();
  }
  return type.compareNodeType(((NodeExpressionAlloc)otherNode).type);
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true; //Nothing to check here, the parser makes sure that the given node is already a type
}

public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("Not implemented");
}

public String toString(String indendation)
{
  return "alloc(" + type.toString(indendation) + ")";
}
}
