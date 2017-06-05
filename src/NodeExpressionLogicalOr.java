public class NodeExpressionLogicalOr extends NodeExpressionBinary{

public NodeExpressionLogicalOr(Node primary_)
{
  super(primary_);
  setOp("||");
}

public String getNodeType()
{
return "NodeExpressionLogicalOr";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
