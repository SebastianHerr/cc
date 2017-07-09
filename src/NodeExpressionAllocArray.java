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

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionAllocArray))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = type.compareNodeType(((NodeExpressionAllocArray)otherNode).type);
  returnValue &= size.compareNodeType(((NodeExpressionAllocArray)otherNode).size);

  return returnValue;
}


public String toString(String indendation)
{
  return "alloc_array(" + type.toString(indendation) + "," + size.toString(indendation) + ")";
}
}
