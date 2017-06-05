public class NodeExpressionBitXor{

Node parent;

public NodeExpressionBitXor()
{
}

public String getNodeType()
{
return "NodeExpressionBitXor";
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
