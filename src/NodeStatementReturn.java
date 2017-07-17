public class NodeStatementReturn extends Node{

Node returnNode;

public NodeStatementReturn(Token token_)
{
  token = token_;
}

public void setReturnValue(Node returnValue_)
{
  returnNode = returnValue_;
  returnNode.setParent(this);
}

public Node getNodeType()
{
  if(returnNode == null)
  {
    return new NodeTypeVoid();
  }
  else
  {
    return returnNode.getNodeType();
  }
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeStatementReturn))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return returnNode.compareNodeType(((NodeStatementReturn)otherNode).returnNode);
}

public String toString(String indendation)
{
  return "return " + ((returnNode==null)?"":" " + returnNode.toString(indendation)) + ";\n";
}
}
