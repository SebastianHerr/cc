public class NodeTypePointer extends Node{

Node pointingTo;

public NodeTypePointer(Node pointingTo_)
{
  pointingTo = pointingTo_;
}

public String getNodeType()
{
return "NodeTypePointer";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return pointingTo + "*";
}
}
