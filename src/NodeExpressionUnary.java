public abstract class NodeExpressionUnary extends Node{

Node innerNode;

public NodeExpressionUnary()
{
}

public String getNodeType()
{
return "NodeExpressionUnary";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setInternNode(Node innerNode_)
{
  innerNode = innerNode_;
  innerNode.setParent(this);
}

}
