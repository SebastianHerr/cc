public class NodeExpressionUnaryMinus{

Node parent;

public NodeExpressionUnaryMinus()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryMinus";
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
