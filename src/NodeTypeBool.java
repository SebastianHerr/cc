public class NodeTypeBool extends Node{

public NodeTypeBool(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeTypeBool";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "boolean";
}
}
