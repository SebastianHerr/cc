public class NodeExpressionUnaryDereference extends NodeExpressionUnary{

public NodeExpressionUnaryDereference(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionUnaryDereference";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "*" + innerNode.toString(indendation);
}
}
