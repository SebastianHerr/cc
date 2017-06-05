public class NodeExpressionConstNum{

Node parent;

public NodeExpressionConstNum()
{
}

public String getNodeType()
{
return "NodeExpressionConstNum";
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
