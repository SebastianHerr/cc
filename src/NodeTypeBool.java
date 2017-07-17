public class NodeTypeBool extends Node{

public NodeTypeBool()
{
}

public NodeTypeBool(Token token_)
{
  token = token_;
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeBool) && !(otherNode instanceof NodeExpressionConstBoolean))
  {
    Thread.dumpStack();
		System.out.println(this.getClass() + "" + otherNode.getClass());
		return false;
  }
  return true;
}

public String toString(String indendation)
{
  return "boolean";
}
}
