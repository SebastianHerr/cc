public class NodeStatementIf extends Node{

Node condition;
Node ifStatement;
Node elseStatement;

public NodeStatementIf(Node condition_, Token token_)
{
  token = token_;
  condition = condition_;
  condition.setParent(this);
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

public String toString(String indendation)
{
  return "if(" + condition.toString(indendation) + ")\n" + 
            ifStatement.toString(indendation) + 
          ((elseStatement==null)?"": indendation +"else\n" + elseStatement.toString(indendation+standardIndentation));
}
}
