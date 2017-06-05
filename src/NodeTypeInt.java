public class NodeTypeInt{

Node parent;

public NodeTypeInt()
{
}

public String getNodeType()
{
return "NodeTypeInt";
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
