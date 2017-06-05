public class NodeStructDeclaration extends Node{

NodeStructSignature name;

public NodeStructDeclaration(NodeStructSignature name_)
{
  name = name_;
}

public String getNodeType()
{
return "NodeStructDeclaration";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return name + ";";
}
}
