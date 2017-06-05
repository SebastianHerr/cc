public class NodeExpressionAllocArray{

Node parent;

public NodeExpressionAllocArray()
{
}

public String getNodeType()
{
return "NodeExpressionAllocArray";
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
