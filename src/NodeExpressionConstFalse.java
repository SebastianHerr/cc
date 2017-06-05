public class NodeExpressionConstFalse{

Node parent;

public NodeExpressionConstFalse()
{
}

public String getNodeType()
{
return "NodeExpressionConstFalse";
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
