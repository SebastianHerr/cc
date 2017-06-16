public abstract class NodeMemberAccess extends Node{

Node accessedNode;
Node accessingNode;

public NodeMemberAccess(Node accessingNode_,Token token_)
{
  token = token_;
  accessingNode = accessingNode_;
  accessingNode.setParent(this);
}

public String getNodeType()
{
return "NodeMemberAccess";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setAccessingNode(Node accessedNode_)
{
  accessedNode = accessedNode_;
}
}
