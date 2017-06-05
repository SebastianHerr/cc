public class NodeStatementReturn{

Node parent;

public NodeStatementReturn()
{
}

public String getNodeType()
{
return "NodeStatementReturn";
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
