package src;

import src.bin.*;

public class NodeStatementExpression extends Node{

Node expression;

public NodeStatementExpression(Node expression_)
{
  expression = expression_;
  expression.setParent(this);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeStatementExpression))
  {
    throw new TypeCheckingException();
  }
  return expression.compareNodeType(((NodeStatementExpression)otherNode).expression);
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public boolean checkNodeType() throws TypeCheckingException
{
  return expression.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  String result = expression.emitCode();
  result += "pop\n";
  return result;
}

public String toString(String indendation)
{
  return expression.toString(indendation) + ";\n";
}
}
