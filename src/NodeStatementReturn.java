package src;

import src.bin.*;

public class NodeStatementReturn extends Node{

Node returnNode;

public NodeStatementReturn(Token token_)
{
  token = token_;
}

public void setReturnValue(Node returnValue_)
{
  returnNode = returnValue_;
  returnNode.setParent(this);
}

public NodeType getNodeType()
{
  //return getContainingFunction().getNodeType();
  if(returnNode == null)
  {
    return new NodeTypeVoid();
  }
  else
  {
    return returnNode.getNodeType();
  }
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeStatementReturn))
  {
    throw new TypeCheckingException();
  }
  return returnNode.compareNodeType(((NodeStatementReturn)otherNode).returnNode);
}

public boolean checkNodeType() throws TypeCheckingException
{
  //If there is no return value given, then the return type of this function needs to be void
  if(returnNode == null)
  {
    getContainingFunction().addReturnStatement(this);
    return getContainingFunction().getNodeType().compareNodeType(new NodeTypeVoid());
  }
  //If there is a return value, then it needs to match the type of the function
  if(!getContainingFunction().getNodeType().compareNodeType(returnNode.getNodeType()))
  {
    return false;
  }
  
  return returnNode.checkNodeType();
}
  
public String emitCode() throws CodeGenerationException
{
  String result = "";
  if(returnNode != null)
  {
    result += returnNode.emitCode();
  }
  result += "storer -3\n";
  result += "return\n";
  return result;
}

public String toString(String indendation)
{
  return "return " + ((returnNode==null)?"":" " + returnNode.toString(indendation)) + ";\n";
}
}
