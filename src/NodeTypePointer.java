public class NodeTypePointer extends Node{

Node pointingTo;

public NodeTypePointer(Node pointingTo_)
{
  pointingTo = pointingTo_;
  pointingTo.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypePointer))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return pointingTo.compareNodeType(((NodeTypePointer)otherNode).pointingTo);
}

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "*";
}
}
