public class NodeFunctionDefinition extends NodeFunctionDeclaration{

Node functionblock;

public NodeFunctionDefinition(NodeFunctionSignature name_, Node functionblock_)
{
   super(name_);
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
  return super.toString(indendation) + "\n" + functionblock.toString(indendation);
}
}
