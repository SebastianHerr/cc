public class NodeExpressionAlloc extends Node{

Node parent;
Node type;

public NodeExpressionAlloc(Node type_)
{
  type = type_;
}

public String getNodeType()
{
return "NodeExpressionAlloc";
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
  return "alloc(" + type + ")";
}
}
