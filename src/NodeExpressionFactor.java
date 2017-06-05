public class NodeExpressionFactor extends NodeExpressionBinary{

public NodeExpressionFactor(Node primary_)
{
  super(primary_);
}

public String getNodeType()
{
return "NodeExpressionFactor";
}

public boolean checkNodeType()
{
return true; //Check okay
}

}
