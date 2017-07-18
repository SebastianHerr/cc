public abstract class NodeMemberAccess extends Node{

Node accessedNode;
Node accessingNode;

public NodeMemberAccess(Node accessingNode_,Token token_)
{
  token = token_;
  accessingNode = accessingNode_;
  accessingNode.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeMemberAccess))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = accessedNode.compareNodeType(((NodeMemberAccess)otherNode).accessedNode);
  returnValue &= accessingNode.compareNodeType(((NodeMemberAccess)otherNode).accessingNode);

  return returnValue;
}

public boolean checkNodeType()
{
  return accessedNode.checkNodeType() && accessingNode.checkNodeType() ;
}

public void setAccessingNode(Node accessedNode_)
{
  accessedNode = accessedNode_;
  accessedNode.setParent(this);
}
}
