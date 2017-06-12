public class NodeExpressionUnaryBitwiseNegation extends NodeExpressionUnary{

public NodeExpressionUnaryBitwiseNegation()
{
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
