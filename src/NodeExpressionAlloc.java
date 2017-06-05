public class NodeExpressionAlloc{

Node parent;

public NodeExpressionAlloc()
{
}

public String getNodeType()
{
return "NodeExpressionAlloc";
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
