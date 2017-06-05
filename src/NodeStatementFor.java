public class NodeStatementFor{

Node parent;

public NodeStatementFor()
{
}

public String getNodeType()
{
return "NodeStatementFor";
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
