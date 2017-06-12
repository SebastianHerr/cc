public class NodeExpressionUnaryDereference extends NodeExpressionUnary{

public NodeExpressionUnaryDereference()
{
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
