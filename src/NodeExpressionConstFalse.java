public class NodeExpressionConstFalse extends Node{

public NodeExpressionConstFalse(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionConstFalse";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "false";
}
}
