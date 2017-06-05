public class NodeMemberAccessDot{

Node parent;

public NodeMemberAccessDot()
{
}

public String getNodeType()
{
return "NodeMemberAccessDot";
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
