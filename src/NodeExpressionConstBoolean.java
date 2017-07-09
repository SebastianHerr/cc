public class NodeExpressionConstBoolean extends Node{

boolean value;

public NodeExpressionConstBoolean(Token token_, boolean value_)
{
  value = value_;
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeBool) && !(otherNode instanceof NodeExpressionConstBoolean))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return true;
}

public String toString(String indendation)
{
  return value ? "true" : "false";
}
}
