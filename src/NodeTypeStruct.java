public class NodeTypeStruct extends Node{

Node name;

public NodeTypeStruct(Node name_)
{
  name = name_;
}

public String getNodeType()
{
return "NodeTypeStruct";
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
