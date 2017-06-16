public class NodeMemberAccessDot extends NodeMemberAccess{

public NodeMemberAccessDot(Node accessingNode_,Token token_)
{
  super(accessingNode_,token_);
}

public String getNodeType()
{
return "NodeMemberAccessDot";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "." + accessingNode.toString(indendation);
}
}
