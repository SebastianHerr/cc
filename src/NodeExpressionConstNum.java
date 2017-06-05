public class NodeExpressionConstNum extends Node{

int value;

public NodeExpressionConstNum(String value_)
{
  value = Integer.parseInt(value_);
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
