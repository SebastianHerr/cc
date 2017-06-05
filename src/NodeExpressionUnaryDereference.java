public class NodeExpressionUnaryDereference{

Node parent;

public NodeExpressionUnaryDereference()
{
}

public String getNodeType()
{
return "NodeExpressionUnaryDereference";
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
