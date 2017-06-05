public class NodeIdentifier{

Node parent;

public NodeIdentifier()
{
}

public String getNodeType()
{
return "NodeIdentifier";
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
