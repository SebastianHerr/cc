public class NodeIdentifier extends Node{

Node parent;
String name;

public NodeIdentifier(String name_)
{
  name = name_;
}

public String getNodeType()
{
return "NodeIdentifier";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}

public String toString()
{
  return name;
}
}
