public class NodeExpressionUnaryNegation extends NodeExpressionUnary{

public NodeExpressionUnaryNegation(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionUnaryNegation";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "!" + innerNode.toString(indendation);
}
}
