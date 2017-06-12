public class NodeTypeInt extends Node{

public NodeTypeInt(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeTypeInt";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "int";
}
}
