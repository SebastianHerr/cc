public class NodeExpressionCompare extends NodeExpressionBinary{

public NodeExpressionCompare(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionCompare";
}

public boolean checkNodeType()
{
return true; //Check okay
}
}
