package src;

import src.bin.*;

public class NodeTypeStruct extends NodeType{

Node name;

public NodeTypeStruct(Node name_)
{
  name = name_;
  name.setParent(this);
}

public NodeTypeStruct()
{
  //Dummy Node for type checking
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeStruct))
  {
    throw new TypeCheckingException();
  }
  return name.compareNodeType(((NodeTypeStruct)otherNode).name);
}

public NodeType getNodeType()
{
  return this;
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
  return "struct " + name.toString(indendation);
}
}
