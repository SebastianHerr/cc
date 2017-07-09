public class NodeMemberAccessArray extends NodeMemberAccess{

public NodeMemberAccessArray(Node accessingNode_,Token token_)
{
  super(accessingNode_, token_);
}

public boolean compareNodeType(Node otherNode)
{
  return super.compareNodeType(otherNode);
}

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "[" + accessingNode.toString(indendation) + "]";
}
}
