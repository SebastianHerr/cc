public class NodeTypeArray extends Node{

Node pointingTo;

public NodeTypeArray(Node pointingTo_)
{
  pointingTo = pointingTo_;
}

public String getNodeType()
{
return "NodeTypeArray";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return pointingTo + "[]";
}
}
