abstract public class NodeExpressionBinary extends Node{

Node primary;
Node secondary;
String op;

public NodeExpressionBinary(Node primary_)
{
  primary = primary_;
  primary.setParent(this);
}

public void setOp(String op_, Token token_)
{
  op = op_;
  token = token_;
}

public void setSecondary(Node secondary_)
{
  secondary = secondary_;
  secondary.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionBinary))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = primary.compareNodeType(((NodeExpressionBinary)otherNode).primary);
  returnValue &= secondary.compareNodeType(((NodeExpressionBinary)otherNode).secondary);
  returnValue &= op == ((NodeExpressionBinary)otherNode).op;
  return returnValue;
}

public String toString(String indendation)
{
  return primary.toString(indendation) + " " + op + " " + secondary.toString(indendation);
}
}
