public class NodeStatementExpression extends Node{

Node expression;

public NodeStatementExpression(Node expression_)
{
  expression = expression_;
  expression.setParent(this);
}

public String getNodeType()
{
return "NodeStatementExpression";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString()
{
  return expression + ";";
}
}
