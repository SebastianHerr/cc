public class NodeExpressionConstNull extends Node{

public NodeExpressionConstNull(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionConstNull))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return true;
}

public Node getNodeType()
{
  return new NodeTypePointer();
}

public String toString(String indendation)
{
  return "NULL";
}
}
