public class NodeExpressionSum extends NodeExpressionBinary{

public NodeExpressionSum(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionSum";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
