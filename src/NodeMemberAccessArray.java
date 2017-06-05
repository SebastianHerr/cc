public class NodeMemberAccessArray extends NodeMemberAccess{

public NodeMemberAccessArray(Node accessingNode_)
{
  super(accessingNode_);
}

public String getNodeType()
{
return "NodeMemberAccessArray";
}

public boolean checkNodeType()
{
return true; //Check okay
}
public String toString()
{
  return accessedNode + "[" + accessingNode + "]";
}
}
