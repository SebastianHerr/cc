public class NodeExpressionConstNull extends Node{

public NodeExpressionConstNull(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionConstNull";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "NULL";
}
}
