public class NodeStatementReturn extends Node{

Node returnValue;

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
  returnValue = returnValue_;
  returnValue.setParent(this);
}

public String toString(String indendation)
{
  return "return " + ((returnValue==null)?"":" " + returnValue.toString(indendation)) + ";\n";
}
}
