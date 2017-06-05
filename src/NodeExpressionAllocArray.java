public class NodeExpressionAllocArray extends Node{

Node parent;
Node type;
Node size;
public NodeExpressionAllocArray(Node type_, Node size_)
{
   type = type_;
   size = size_;
}

public String getNodeType()
{
return "NodeExpressionAllocArray";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}
public String toString()
{
  return "alloc_array(" + type + "," + size + ")";
}
}
