public class NodeFunctionDefinition{

Node parent;

public NodeFunctionDefinition()
{
}

public String getNodeType()
{
return "NodeFunctionDefinition";
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
