package src;

import src.bin.*;

public class NodeExpressionAllocArray extends Node{

Node type;
Node size;
public NodeExpressionAllocArray(Node type_, Token token_, Node size_)
{
   token = token_;
   type = type_;
   type.setParent(this);
   size = size_;
   size.setParent(this);
}

public Node getNodeType()
{
  return new NodeTypePointer(new NodeTypeInt());
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionAllocArray))
  {
    throw new TypeCheckingException();
  }
  boolean returnValue = type.compareNodeType(((NodeExpressionAllocArray)otherNode).type);
  returnValue &= size.compareNodeType(((NodeExpressionAllocArray)otherNode).size);

  return returnValue;
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
  return "alloc_array(" + type.toString(indendation) + "," + size.toString(indendation) + ")";
}
}
