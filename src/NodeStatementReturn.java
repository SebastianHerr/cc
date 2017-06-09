public class NodeStatementReturn extends Node{

Node returnValue;

public NodeStatementReturn()
{
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

public String toString()
{
  return "return " + ((returnValue==null)?"":" " + returnValue) + ";";
}
}
