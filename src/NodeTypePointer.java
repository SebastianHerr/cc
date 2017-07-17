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
  if(!(otherNode instanceof NodeTypePointer))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
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

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "*";
}
}
