public class NodeTypePointer extends Node{

Node pointingTo;

public NodeTypePointer(Node pointingTo_)
{
  pointingTo = pointingTo_;
  pointingTo.setParent(this);
}

public NodeTypePointer()
{
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(getParent() == null || otherNode.getParent() == null)
  {
    //If a parent is null, then it's not part of the main ast and only used to check if this is actually a pointer to somewhere
    return compareNodeType(otherNode, true);
  }
  else
  {    
    return compareNodeType(otherNode, false);
  }
}

public boolean compareNodeType(Node otherNode, boolean onelevel) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypePointer || otherNode instanceof NodeTypeInt ))
  {
    throw new TypeCheckingException();
  }
  
  if(onelevel || otherNode instanceof NodeTypeInt)
  {
    return true;
  }
  
  NodeTypePointer otherNodeCast = (NodeTypePointer)otherNode;
  if(pointingTo != null && otherNodeCast.pointingTo != null)
  {
    return pointingTo.compareNodeType(((NodeTypePointer)otherNode).pointingTo);
  }
  else if (pointingTo == null && otherNodeCast.pointingTo == null)
  {
    return true;
  }
  else
  {
    return false;
  }
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public String emitCode() throws CodeGenerationException
{
  throw new CodeGenerationException("No code generation for type nodes");
}

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "*";
}
}
