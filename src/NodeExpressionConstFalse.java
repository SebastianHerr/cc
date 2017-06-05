public class NodeExpressionConstFalse extends Node{

public NodeExpressionConstFalse()
{
}

public String getNodeType()
{
return "NodeExpressionConstFalse";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "false";
}
}
