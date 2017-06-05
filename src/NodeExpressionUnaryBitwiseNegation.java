public class NodeExpressionUnaryBitwiseNegation{

Node parent;

public NodeExpressionUnaryBitwiseNegation()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryBitwiseNegation";
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
