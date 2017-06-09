public class NodeExpressionAllocArray extends Node{

Node type;
Node size;
public NodeExpressionAllocArray(Node type_, Node size_)
{
   type = type_;
   type.setParent(this);
   size = size_;
   size.setParent(this);
}

public String getNodeType()
{
return "NodeExpressionAllocArray";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "alloc_array(" + type + "," + size + ")";
}
}
