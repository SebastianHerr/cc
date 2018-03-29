package src;

import src.bin.*;

public class NodeExpressionBrackets extends Node{

Node node;

public NodeExpressionBrackets(Node node_, Token token_)
{
  node = node_;
  node.setParent(this);
  token = token_;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionBrackets))
  {
    throw new TypeCheckingException();
  }
  return node.compareNodeType(((NodeExpressionBrackets)otherNode).node);
}

public String emitCode() throws CodeGenerationException
{
  return node.emitCode();
}

public String toString(String indentation)
{
  return "(" + node.toString(indentation) + ")";
}

public NodeType getNodeType()
{
  return node.getNodeType();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return node.checkNodeType();
}

}
