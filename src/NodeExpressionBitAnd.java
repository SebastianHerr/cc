public class NodeExpressionBitAnd extends NodeExpressionBinary{

public NodeExpressionBitAnd(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionBitAnd";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
