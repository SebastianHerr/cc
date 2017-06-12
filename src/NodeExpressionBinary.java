abstract public class NodeExpressionBinary extends Node{

Node primary;
Node secondary;
String op;

public NodeExpressionBinary(Node primary_)
{
  primary = primary_;
  primary.setParent(this);
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
  secondary.setParent(this);
}

public String toString(String indendation)
{
  return primary.toString(indendation) + " " + op + " " + secondary.toString(indendation);
}
}
