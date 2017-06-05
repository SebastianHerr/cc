public class NodeExpressionUnaryMinus extends NodeExpressionUnary{

public NodeExpressionUnaryMinus()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryMinus";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "-" + innerNode;
}
}
