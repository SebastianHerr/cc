package src;

import src.bin.*;

public class NodeStatementWhile extends Node{

Node condition;
Node loopBody;

public NodeStatementWhile(Node condition_, Token token_)
{
  token = token_;
  condition = condition_;
  condition.setParent(this);
}

public void setLoopBody(Node loopBody_)
{
  loopBody = loopBody_;
  loopBody.setParent(this);
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeStatementWhile))
  {
    throw new TypeCheckingException();
  }
  boolean returnValue = condition.compareNodeType(((NodeStatementWhile)otherNode).condition);
  returnValue &= loopBody.compareNodeType(((NodeStatementWhile)otherNode).loopBody);

  return returnValue;
}

public boolean checkNodeType() throws TypeCheckingException
{
  if(!condition.getNodeType().compareNodeType(new NodeTypeBool()))
    return false;
  
  return condition.checkNodeType() && loopBody.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  String loopBegin = "whileStart" + JumpPointerManager.getID();
  String loopEnd = "whileEnd" + JumpPointerManager.getID();
  String result = loopBegin + ":" + condition.emitCode();
  result += "jumpz " +loopEnd + "\n";
  result += loopBody.emitCode();
  result += "jump " + loopBegin + "\n";
  result += loopEnd + ":" + CMAnop + "\n";
  return result;
}

public String toString(String indentation)
{
  return indentation + "while(" + condition.toString(indentation) +")\n" 
    + loopBody.toString(indentation);
}
}
