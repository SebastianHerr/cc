public class NodeExpressionConstTrue extends Node{

public NodeExpressionConstTrue()
{
}

public String getNodeType()
{
return "NodeExpressionConstTrue";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "true";
}
}
