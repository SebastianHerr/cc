public class NodeExpressionAssign{

Node parent;

public NodeExpressionAssign()
{
}

public String getNodeType()
{
return "NodeExpressionAssign";
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
