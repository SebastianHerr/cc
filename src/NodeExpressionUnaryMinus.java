public class NodeExpressionUnaryMinus extends NodeExpressionUnary{

public NodeExpressionUnaryMinus(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionUnaryMinus";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "-" + innerNode.toString(indendation);
}
}
