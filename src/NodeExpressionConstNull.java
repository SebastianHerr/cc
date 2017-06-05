public class NodeExpressionConstNull extends Node{

public NodeExpressionConstNull()
{
}

public String getNodeType()
{
return "NodeExpressionConstNull";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "null";
}
}
