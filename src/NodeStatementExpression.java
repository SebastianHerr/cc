public class NodeStatementExpression extends Node{

Node expression;

public NodeStatementExpression(Node expression_)
{
  expression = expression_;
  expression.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeStatementExpression))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return expression.compareNodeType(((NodeStatementExpression)otherNode).expression);
}

public String toString(String indendation)
{
  return expression.toString(indendation) + ";\n";
}
}
