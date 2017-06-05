public class NodeExpressionBitShift extends NodeExpressionBinary{

public NodeExpressionBitShift(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionBitShift";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
