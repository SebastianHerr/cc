public class NodeFunctionDefinition extends Node{

NodeFunctionSignature name;
Node functionblock;

public NodeFunctionDefinition(NodeFunctionSignature name_, Node functionblock_)
{
   name = name_;
   name.setParent(this);
   functionblock = functionblock_;
   functionblock.setParent(this);
}

public String getNodeType()
{
return "NodeFunctionDefinition";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indendation)
{
  return name.toString(indendation) + "" + functionblock.toString(indendation) + "\n";
}
}
