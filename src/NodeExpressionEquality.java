public class NodeExpressionEquality{

Node parent;

public NodeExpressionEquality()
{
}

public String getNodeType()
{
return "NodeExpressionEquality";
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
