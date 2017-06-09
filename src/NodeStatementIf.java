public class NodeStatementIf extends Node{

Node condition;
Node ifStatement;
Node elseStatement;

public NodeStatementIf(Node condition_)
{
  condition = condition_;
}

public String getNodeType()
{
return "NodeStatementIf";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setIf(Node statement)
{
  ifStatement = statement;
  ifStatement.setParent(this);
}

public void setElse(Node statement)
{
  elseStatement = statement;
  elseStatement.setParent(this);
}

public String toString()
{
  return "if(" + condition + ")" + ifStatement + ((elseStatement==null)?"":"else " + elseStatement + "");
}
}
