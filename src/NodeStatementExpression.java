public class NodeStatementExpression{

Node parent;

public NodeStatementExpression()
{
}

public String getNodeType()
{
return "NodeStatementExpression";
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
