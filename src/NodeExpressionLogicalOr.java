public class NodeExpressionLogicalOr extends NodeExpressionBinary{

public NodeExpressionLogicalOr(Node primary_)
{
  super(primary_);
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
