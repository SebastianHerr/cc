package src;

import src.bin.*;

public class NodeExpressionDecrement extends Node{

NodeIdentifier innerNode;

public NodeExpressionDecrement(NodeIdentifier innerNode_,Token token_)
{
  token = token_;
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionDecrement))
  {
    throw new TypeCheckingException();
  }
  return innerNode.compareNodeType(((NodeExpressionDecrement)otherNode).innerNode);
}

public NodeType getNodeType()
{
  return new NodeTypeInt();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.getNodeType().compareNodeType(new NodeTypeInt());
}

public String emitCode() throws CodeGenerationException
{
  String result = "";
  result += "loadc " + innerNode.getStackAdress() + "\n";
  result += "load 1\n";
  result += "loadc 1\n";
  result += "sub\n";
  result += "loadc " + innerNode.getStackAdress() + "\n";
  result += "store 1\n";
  // += "pop\n";
  return result;
}

public String toString(String indendation)
{
  return innerNode.toString(indendation) + "--";
}
}
