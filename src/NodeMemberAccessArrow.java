public class NodeMemberAccessArrow extends NodeMemberAccess{

public NodeMemberAccessArrow(Node accessingNode_)
{
  super(accessingNode_);
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
