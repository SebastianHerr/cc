package src;

import src.bin.*;

public class NodeExpressionIncrement extends Node{

NodeIdentifier innerNode;

public NodeExpressionIncrement(NodeIdentifier innerNode_, Token token_)
{
  token = token_;
  innerNode = innerNode_;
  innerNode.setParent(this);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionIncrement))
  {
    throw new TypeCheckingException();
  }
  return innerNode.compareNodeType(((NodeExpressionIncrement)otherNode).innerNode);
}

public Node getNodeType()
{
  return new NodeTypeInt();
}

public boolean checkNodeType() throws TypeCheckingException
{
  return innerNode.getNodeType().compareNodeType(new NodeTypeInt()) && innerNode.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  String result = "";
  result += "loadc " + innerNode.getStackAdress() + "\n";
  result += "load 1\n";
  result += "loadc 1\n";
  result += "add\n";
  result += "loadc " + innerNode.getStackAdress() + "\n";
  result += "store 1\n";
  // += "pop\n";
  return result;
}

public String toString(String indendation)
{
  return innerNode.toString(indendation) + "++";
}
}
