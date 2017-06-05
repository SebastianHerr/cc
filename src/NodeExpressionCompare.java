public class NodeExpressionCompare{

Node parent;

public NodeExpressionCompare()
{
}

public String getNodeType()
{
return "NodeExpressionCompare";
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
