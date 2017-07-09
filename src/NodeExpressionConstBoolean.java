public class NodeExpressionConstBoolean extends Node{

boolean value;

public NodeExpressionConstBoolean(Token token_, boolean value_)
{
  value = value_;
  token = token_;
}

public String toString(String indendation)
{
  return value ? "true" : "false";
}
}
