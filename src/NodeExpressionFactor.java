public class NodeExpressionFactor{

Node parent;

public NodeExpressionFactor()
{
}

public String getNodeType()
{
return "NodeExpressionFactor";
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
