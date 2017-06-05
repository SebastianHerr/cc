public class NodeExpressionBitOr{

Node parent;

public NodeExpressionBitOr()
{
}

public String getNodeType()
{
return "NodeExpressionBitOr";
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
