public class NodeExpressionBitAnd{

Node parent;

public NodeExpressionBitAnd()
{
}

public String getNodeType()
{
return "NodeExpressionBitAnd";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}
}
