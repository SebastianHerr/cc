public class NodeFunctionDeclaration{

Node parent;

public NodeFunctionDeclaration()
{
}

public String getNodeType()
{
return "NodeFunctionDeclaration";
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
