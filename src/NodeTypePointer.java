public class NodeTypePointer{

Node parent;

public NodeTypePointer()
{
}

public String getNodeType()
{
return "NodeTypePointer";
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
