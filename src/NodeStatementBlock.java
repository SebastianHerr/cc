public class NodeStatementBlock{

Node parent;

public NodeStatementBlock()
{
}

public String getNodeType()
{
return "NodeStatementBlock";
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
