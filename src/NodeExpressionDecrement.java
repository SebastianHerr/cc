public class NodeExpressionDecrement{

Node parent;

public NodeExpressionDecrement()
{
}

public String getNodeType()
{
return "NodeExpressionDecrement";
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
