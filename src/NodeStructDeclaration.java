public class NodeStructDeclaration{

Node parent;

public NodeStructDeclaration()
{
}

public String getNodeType()
{
return "NodeStructDeclaration";
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
