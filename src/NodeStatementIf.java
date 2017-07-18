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

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeStatementIf))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  NodeStatementIf otherNodeIf = (NodeStatementIf)otherNode;
  boolean returnValue = condition.compareNodeType(otherNodeIf.condition);
  returnValue &= ifStatement.compareNodeType(otherNodeIf.ifStatement);
  returnValue &= elseStatement.compareNodeType(otherNodeIf.elseStatement);

  return returnValue;
}

public boolean checkNodeType()
{
  //The condition needs to be boolean
  if(!condition.getNodeType().compareNodeType(new NodeTypeBool()))
  {
    return false;
  }
  return condition.checkNodeType() && ifStatement.checkNodeType() && (elseStatement != null ? elseStatement.checkNodeType() : true);
}


public String toString(String indendation)
{
  return "if(" + condition.toString(indendation) + ")\n" + 
            ifStatement.toString(indendation) + 
          ((elseStatement==null)?"": indendation +"else\n" + elseStatement.toString(indendation+standardIndentation));
}
}
