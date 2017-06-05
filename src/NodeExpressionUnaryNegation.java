public class NodeExpressionUnaryNegation{

Node parent;

public NodeExpressionUnaryNegation()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryNegation";
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
