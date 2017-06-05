public class NodeExpressionConditional{

Node parent;

public NodeExpressionConditional()
{
}

public String getNodeType()
{
return "NodeExpressionConditional";
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
