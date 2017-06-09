public class NodeStatementFor extends Node{

Node init;
Node condition;
Node iterator;
Node loopBody;

public NodeStatementFor()
{
}

public String getNodeType()
{
return "NodeStatementFor";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setInitializer(Node init_)
{
  init = init_;
  init.setParent(this);
}

public void setCondition(Node condition_)
{
  condition = condition_;
  condition.setParent(this);
}

public void setIterator(Node iterator_)
{
  iterator = iterator_;
  iterator.setParent(this);
}

public void setLoopBody(Node loopBody_)
{
  loopBody = loopBody_;
  loopBody.setParent(this);
}

public String toString()
{
  return "for(" + init + ";" + condition + ";" + iterator + ")" + loopBody;
}
}
