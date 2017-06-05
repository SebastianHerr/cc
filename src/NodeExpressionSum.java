public class NodeExpressionSum{

Node parent;

public NodeExpressionSum()
{
}

public String getNodeType()
{
return "NodeExpressionSum";
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
