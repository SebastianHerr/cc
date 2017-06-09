public class NodeTypeVoid extends Node{

public NodeTypeVoid(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeTypeVoid";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "void";
}
}
