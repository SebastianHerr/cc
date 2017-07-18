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

public boolean compareNodeType(Node otherNode)
{
  return compareNodeType(otherNode, false);
}

public boolean compareNodeType(Node otherNode, boolean onelevel)
{
  if(!(otherNode instanceof NodeTypePointer))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  
  if(onelevel)
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
  
public boolean checkNodeType()
{
  return true;
}

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "*";
}
}
