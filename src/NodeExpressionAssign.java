package src;

import src.bin.*;

public class NodeExpressionAssign extends NodeExpressionBinary{

public NodeExpressionAssign(Node primary_)
{
  super(primary_);
}

public NodeType getNodeType()
{
  return primary.getNodeType();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  //Primary side needs to be assingable...
  if(!(primary instanceof IAssignable))
  {    
    throw new TypeCheckingException("Assigment is not of an assinable type");
  }
  
  //... and both sides need to be the same, no futher conditions
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  String result = secondary.emitCode();
  result += "loadc " + ((IAssignable)primary).getStackAdress() + "\n";
  result += "store\n";
  return result;
}
}
