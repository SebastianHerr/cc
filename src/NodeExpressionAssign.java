public class NodeExpressionAssign extends NodeExpressionBinary{

public NodeExpressionAssign(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionAssign";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
