package src;

import src.bin.*;

public class NodeMemberAccessArray extends NodeMemberAccess{

public NodeMemberAccessArray(Node accessingNode_,Token token_)
{
  super(accessingNode_, token_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  return super.compareNodeType(otherNode);
}

public Node getNodeType()
{
  return accessedNode.getNodeType();
}

public boolean checkNodeType() throws TypeCheckingException
{
  if(!accessedNode.getNodeType().compareNodeType(new NodeTypePointer()) || !accessingNode.getNodeType().compareNodeType(new NodeTypeInt()))
  {
    return false;
  }
  return accessedNode.checkNodeType() && accessingNode.checkNodeType();
}

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "[" + accessingNode.toString(indendation) + "]";
}
}
