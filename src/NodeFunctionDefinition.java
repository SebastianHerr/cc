public class NodeFunctionDefinition extends Node{

NodeFunctionSignature name;
Node functionblock;

public NodeFunctionDefinition(NodeFunctionSignature name_, Node functionblock_)
{
   name = name_;
   functionblock = functionblock_;
}

public String getNodeType()
{
return "NodeFunctionDefinition";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return name + "" + functionblock;
}
}
