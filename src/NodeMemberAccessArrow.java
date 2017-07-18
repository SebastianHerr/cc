public class NodeMemberAccessArrow extends NodeMemberAccess{

public NodeMemberAccessArrow(Node accessingNode_,Token token_)
{
  super(accessingNode_,token_);
}

public boolean compareNodeType(Node otherNode)
{
  return super.compareNodeType(otherNode);
}

public Node getNodeType()
{
  return accessedNode.getNodeType();
}

public boolean checkNodeType()
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
