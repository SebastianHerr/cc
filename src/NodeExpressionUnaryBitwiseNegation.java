public class NodeExpressionUnaryBitwiseNegation extends NodeExpressionUnary{

public NodeExpressionUnaryBitwiseNegation(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionUnaryBitwiseNegation";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "~" + innerNode.toString(indendation);
}

}
