public class NodeExpressionLogicalAnd extends NodeExpressionBinary{

public NodeExpressionLogicalAnd(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionLogicalAnd";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
