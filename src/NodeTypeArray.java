public class NodeTypeArray extends Node{

Node pointingTo;

public NodeTypeArray(Node pointingTo_)
{
  pointingTo = pointingTo_;
  pointingTo.setParent(this);
}

public NodeTypeArray()
{
  //Dummy node for type checking
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeArray))
  {
    throw new TypeCheckingException();
  }
  return pointingTo.compareNodeType(((NodeTypeArray)otherNode).pointingTo);
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
  return pointingTo.toString(indendation) + "[]";
}
}
