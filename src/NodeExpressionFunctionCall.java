public class NodeExpressionFunctionCall{

Node parent;

public NodeExpressionFunctionCall()
{
}

public String getNodeType()
{
return "NodeExpressionFunctionCall";
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
