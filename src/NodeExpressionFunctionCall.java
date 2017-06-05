public class NodeExpressionFunctionCall extends Node{

Node name; 
NodeFunctionCallArgs args;

public NodeExpressionFunctionCall(Node name_, NodeFunctionCallArgs args_)
{
  name = name_;
  args = args_;
}

public String getNodeType()
{
return "NodeExpressionFunctionCall";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return name + "(" + args + ")";
}
}
