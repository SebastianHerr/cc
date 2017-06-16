public class NodeExpressionAlloc extends Node{

Node type;

public NodeExpressionAlloc(Node type_, Token token_)
{
  type = type_;
  token = token_;
  type.setParent(this);
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

public String toString(String indendation)
{
  return "alloc(" + type.toString(indendation) + ")";
}
}
