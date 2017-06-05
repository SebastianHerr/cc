public class NodeStructSignature extends Node{

Node name;

public NodeStructSignature(Node name_)
{
  name = name_;
}

public String getNodeType()
{
return "NodeStructSignature";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return "struct " + name;
}
}
