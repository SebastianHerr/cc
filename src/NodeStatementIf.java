package src;

import src.bin.*;

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

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeStatementIf))
  {
    throw new TypeCheckingException();
  }
  NodeStatementIf otherNodeIf = (NodeStatementIf)otherNode;
  boolean returnValue = condition.compareNodeType(otherNodeIf.condition);
  returnValue &= ifStatement.compareNodeType(otherNodeIf.ifStatement);
  returnValue &= elseStatement.compareNodeType(otherNodeIf.elseStatement);

  return returnValue;
}

public boolean checkNodeType() throws TypeCheckingException
{
  //The condition needs to be boolean
  if(!condition.getNodeType().compareNodeType(new NodeTypeBool()))
  {
    return false;
  }
  return condition.checkNodeType() && ifStatement.checkNodeType() && (elseStatement != null ? elseStatement.checkNodeType() : true);
}

public String emitCode() throws CodeGenerationException
{
  String jumpToElse = "jumpToElse" + JumpPointerManager.getID();
  String jumpOverElse = "jumpOverElse" + JumpPointerManager.getID();
  String result = condition.emitCode();
  
  if(elseStatement != null)
  {
    result += "jumpz " + jumpToElse + "\n";
    result += ifStatement.emitCode();
    result += "jump " + jumpOverElse + "\n";
    result += jumpToElse + ":" + elseStatement.emitCode();
    result += jumpOverElse + ":" + CMAnop + "\n";
  }
  else
  {
    result += "jumpz " + jumpOverElse + "\n";
    result += ifStatement.emitCode();
    result += jumpOverElse + ":" + CMAnop + "\n";
  }
  
  return result;
}

public String toString(String indendation)
{
  return "if(" + condition.toString(indendation) + ")\n" + 
            ifStatement.toString(indendation) + 
          ((elseStatement==null)?"": indendation +"else\n" + elseStatement.toString(indendation+standardIndentation));
}
}
