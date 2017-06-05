public class NodeFunctionCallArgs{

Node parent;

public NodeFunctionCallArgs()
{
}

public String getNodeType()
{
return "NodeFunctionCallArgs";
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
