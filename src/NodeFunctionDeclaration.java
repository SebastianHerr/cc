public class NodeFunctionDeclaration extends Node{

NodeFunctionSignature name;

public NodeFunctionDeclaration(NodeFunctionSignature name_)
{
   name = name_;
   name.setParent(this);
}

public String getNodeType()
{
return "NodeFunctionDeclaration";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return name + ";\n";
}
}
