public class NodeExpressionUnaryNegation extends NodeExpressionUnary{

public NodeExpressionUnaryNegation()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryNegation";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "!" + innerNode;
}
}
