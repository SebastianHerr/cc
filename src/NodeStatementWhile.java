public class NodeStatementWhile extends Node{

Node condition;
Node loopBody;

public NodeStatementWhile(Node condition_)
{
  condition = condition_;
  condition.setParent(this);
}

public String getNodeType()
{
return "NodeStatementWhile";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setLoopBody(Node loopBody_)
{
  loopBody = loopBody_;
  loopBody.setParent(this);
}

public String toString()
{
  return "while(" + condition +"){" + loopBody + "}";
}
}
