package src;

import src.bin.*;

public abstract class NodeMemberAccess extends Node{

Node accessedNode;
Node accessingNode;

public NodeMemberAccess(Node accessingNode_,Token token_)
{
  token = token_;
  accessingNode = accessingNode_;
  accessingNode.setParent(this);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeMemberAccess))
  {
    throw new TypeCheckingException();
  }
  boolean returnValue = accessedNode.compareNodeType(((NodeMemberAccess)otherNode).accessedNode);
  returnValue &= accessingNode.compareNodeType(((NodeMemberAccess)otherNode).accessingNode);

  return returnValue;
}

public void setAccessingNode(Node accessedNode_)
{
  accessedNode = accessedNode_;
  accessedNode.setParent(this);
}
  
public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("Not implemented");
}
}
