public class NodeTypeStruct{

Node parent;

public NodeTypeStruct()
{
}

public String getNodeType()
{
return "NodeTypeStruct";
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
