public class NodeStatementIf{

Node parent;

public NodeStatementIf()
{
}

public String getNodeType()
{
return "NodeStatementIf";
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
