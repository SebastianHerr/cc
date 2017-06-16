public class NodeExpressionBitOr extends NodeExpressionBinary{

public NodeExpressionBitOr(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionBitOr";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
