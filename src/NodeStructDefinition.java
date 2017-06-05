public class NodeStructDefinition{

Node parent;

public NodeStructDefinition()
{
}

public String getNodeType()
{
return "NodeStructDefinition";
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
