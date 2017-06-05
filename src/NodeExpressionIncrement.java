public class NodeExpressionIncrement{

Node parent;

public NodeExpressionIncrement()
{
}

public String getNodeType()
{
return "NodeExpressionIncrement";
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
