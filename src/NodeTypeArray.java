public class NodeTypeArray extends Node{

Node pointingTo;

public NodeTypeArray(Node pointingTo_)
{
  pointingTo = pointingTo_;
  pointingTo.setParent(this);
}

public NodeTypeArray()
{
  //Dummy node for type checking
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeArray))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return pointingTo.compareNodeType(((NodeTypeArray)otherNode).pointingTo);
}
  
public boolean checkNodeType()
{
  return true;
}

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "[]";
}
}
