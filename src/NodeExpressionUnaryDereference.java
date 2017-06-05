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

public String toString()
{
  return "*" + innerNode;
}
}
