abstract public class NodeExpressionBinary extends Node{

Node primary;
Node secondary;
String op;

public NodeExpressionBinary(Node primary_)
{
  primary = primary_;
}

public String getNodeType()
{
return "NodeExpressionBinary";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setOp(String op_)
{
  op = op_;
}

public void setSecondary(Node secondary_)
{
  secondary = secondary_;
}

public String toString()
{
  return primary + op + secondary;
}
}
