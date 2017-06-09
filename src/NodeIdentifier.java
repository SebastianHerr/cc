public class NodeIdentifier extends Node{

public NodeIdentifier(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeIdentifier";
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
  return token.image;
}
}
