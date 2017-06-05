public class NodeStatementWhile{

Node parent;

public NodeStatementWhile()
{
}

public String getNodeType()
{
return "NodeStatementWhile";
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
