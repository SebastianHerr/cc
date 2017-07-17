public class NodeMemberAccessDot extends NodeMemberAccess{

public NodeMemberAccessDot(Node accessingNode_,Token token_)
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

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "." + accessingNode.toString(indendation);
}
}
