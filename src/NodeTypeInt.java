public class NodeTypeInt extends Node{

public NodeTypeInt(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeInt) && !(otherNode instanceof NodeExpressionConstNum))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return true;
}

public String toString(String indendation)
{
  return "int";
}
}
