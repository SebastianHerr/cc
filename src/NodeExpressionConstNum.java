public class NodeExpressionConstNum extends Node{

int value;

public NodeExpressionConstNum(Token token_)
{
  token = token_;
  value = Integer.parseInt(token.image);
}

public String getNodeType()
{
return "NodeExpressionConstNum";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return value + "";
}
}
