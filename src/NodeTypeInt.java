public class NodeTypeInt extends Node{

public NodeTypeInt()
{
}

public NodeTypeInt(Token token_)
{
  token = token_;
}

public Node getNodeType()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeInt) && !(otherNode instanceof NodeExpressionConstNum) && !(otherNode instanceof NodeTypePointer))
  { 
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return true;
}
  
public boolean checkNodeType()
{
  return true;
}

public String toString(String indendation)
{
  return "int";
}
}
