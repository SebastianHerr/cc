public class NodeTypeBool{

Node parent;

public NodeTypeBool()
{
}

public String getNodeType()
{
return "NodeTypeBool";
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
