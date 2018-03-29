package src;

import src.bin.*;

public class NodeMemberAccessArrow extends NodeMemberAccess{

public NodeMemberAccessArrow(Node accessingNode_,Token token_)
{
  super(accessingNode_,token_);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  return super.compareNodeType(otherNode);
}

public NodeType getNodeType()
{
  return accessedNode.getNodeType();
}

public boolean checkNodeType() throws TypeCheckingException
{
  if(!accessedNode.getNodeType().compareNodeType(new NodeTypePointer()))
  {
    return false;
  }
  return accessedNode.checkNodeType() && accessingNode.checkNodeType();
}

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "->" + accessingNode.toString(indendation);
}
}
