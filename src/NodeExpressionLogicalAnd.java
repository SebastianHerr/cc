public class NodeExpressionLogicalAnd{

Node parent;

public NodeExpressionLogicalAnd()
{
}

public String getNodeType()
{
return "NodeExpressionLogicalAnd";
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
