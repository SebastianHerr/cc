public class NodeTypeVoid extends Node{

public NodeTypeVoid(Token token_)
{
  token = token_;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeVoid))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  else
    return true;
}

public String toString(String indendation)
{
  return "void";
}
}
