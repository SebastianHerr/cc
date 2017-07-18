public class NodeExpressionConstNum extends Node{

int value;

public NodeExpressionConstNum(Token token_)
{
  token = token_;
  value = Integer.parseInt(token.image);
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

public Node getNodeType()
{
  return new NodeTypeInt();
}
  
public boolean checkNodeType()
{
  return true;
}

public String toString(String indendation)
{
  return value + "";
}
}
