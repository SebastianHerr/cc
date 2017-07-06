public class NodeStatementReturn extends Node{

Node returnNode;

public NodeStatementReturn(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeStatementReturn";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setReturnValue(Node returnValue_)
{
  returnNode = returnValue_;
  returnNode.setParent(this);
}

public String toString(String indendation)
{
  return "return " + ((returnNode==null)?"":" " + returnNode.toString(indendation)) + ";\n";
}
}
