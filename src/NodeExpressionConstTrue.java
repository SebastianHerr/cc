public class NodeExpressionConstTrue{

Node parent;

public NodeExpressionConstTrue()
{
}

public String getNodeType()
{
return "NodeExpressionConstTrue";
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
