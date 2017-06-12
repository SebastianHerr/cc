public class NodeTypeArray extends Node{

Node pointingTo;

public NodeTypeArray(Node pointingTo_)
{
  pointingTo = pointingTo_;
  pointingTo.setParent(this);
}

public String getNodeType()
{
return "NodeTypeArray";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return pointingTo.toString(indendation) + "[]";
}
}
