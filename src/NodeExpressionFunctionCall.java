public class NodeExpressionFunctionCall extends Node{

Node name; 
NodeFunctionCallArgs args;

public NodeExpressionFunctionCall(Node name_, NodeFunctionCallArgs args_)
{
  name = name_;
  name.setParent(this);
  args = args_;
  args.setParent(this);
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
