public class NodeExpressionEquality extends NodeExpressionBinary{

public NodeExpressionEquality(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionEquality";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
