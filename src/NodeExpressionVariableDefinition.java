public class NodeExpressionVariableDefinition{

Node parent;

public NodeExpressionVariableDefinition()
{
}

public String getNodeType()
{
return "NodeExpressionVariableDefinition";
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
