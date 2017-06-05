public class NodeTypeArray{

Node parent;

public NodeTypeArray()
{
}

public String getNodeType()
{
return "NodeTypeArray";
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
