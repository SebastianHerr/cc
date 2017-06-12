public class NodeStructSignature extends Node{

Node name;

public NodeStructSignature(Node name_)
{
  name = name_;
  name.setParent(this);
}

public String getNodeType()
{
return "NodeStructSignature";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return "struct " + name.toString(indendation);
}
}
