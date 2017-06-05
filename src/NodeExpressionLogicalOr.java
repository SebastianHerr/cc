public class NodeExpressionLogicalOr{

Node parent;

public NodeExpressionLogicalOr()
{
}

public String getNodeType()
{
return "NodeExpressionLogicalOr";
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
