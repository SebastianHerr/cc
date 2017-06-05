public class NodeExpressionBitShift{

Node parent;

public NodeExpressionBitShift()
{
}

public String getNodeType()
{
return "NodeExpressionBitShift";
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
