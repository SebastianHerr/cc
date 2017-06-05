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
public String toString()
{
  return accessedNode + "->" + accessingNode;
}
}
