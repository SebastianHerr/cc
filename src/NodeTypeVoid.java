public class NodeTypeVoid{

Node parent;

public NodeTypeVoid()
{
}

public String getNodeType()
{
return "NodeTypeVoid";
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
