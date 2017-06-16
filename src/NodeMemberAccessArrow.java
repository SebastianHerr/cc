public class NodeMemberAccessArrow extends NodeMemberAccess{

public NodeMemberAccessArrow(Node accessingNode_,Token token_)
{
  super(accessingNode_,token_);
}

public String getNodeType()
{
return "NodeMemberAccessArrow";
}

public boolean checkNodeType()
{
return true; //Check okay
}
public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "->" + accessingNode.toString(indendation);
}
}
