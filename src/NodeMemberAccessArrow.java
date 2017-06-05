public class NodeMemberAccessArrow{

Node parent;

public NodeMemberAccessArrow()
{
}

public String getNodeType()
{
return "NodeMemberAccessArrow";
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
