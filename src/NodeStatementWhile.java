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

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeStatementWhile))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = condition.compareNodeType(((NodeStatementWhile)otherNode).condition);
  returnValue &= loopBody.compareNodeType(((NodeStatementWhile)otherNode).loopBody);

  return returnValue;
}

public String toString(String indentation)
{
  return indentation + "while(" + condition.toString(indentation) +")\n" 
    + loopBody.toString(indentation);
}
}
