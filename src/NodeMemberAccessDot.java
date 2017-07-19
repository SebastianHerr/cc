public class NodeMemberAccessDot extends NodeMemberAccess{

public NodeMemberAccessDot(Node accessingNode_,Token token_)
{
  super(accessingNode_,token_);
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
  if(!accessedNode.getNodeType().compareNodeType(new NodeTypeStruct()))
  {
    return false;
  }
  return accessedNode.checkNodeType() && accessingNode.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("Not implemented");
}

public String toString(String indendation)
{
  return accessedNode.toString(indendation) + "." + accessingNode.toString(indendation);
}
}
