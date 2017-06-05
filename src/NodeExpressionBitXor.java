public class NodeExpressionBitXor extends NodeExpressionBinary{

public NodeExpressionBitXor(Node primary_)
{
  super(primary_);
  setOp("^");
}

public String getNodeType()
{
return "NodeExpressionBitXor";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
