public class NodeMemberAccessArray{

Node parent;

public NodeMemberAccessArray()
{
}

public String getNodeType()
{
return "NodeMemberAccessArray";
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
