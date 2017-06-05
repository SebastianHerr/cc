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
}

public void setCondition(Node condition_)
{
  condition = condition_;
}

public void setIterator(Node iterator_)
{
  iterator = iterator_;
}

public void setLoopBody(Node loopBody_)
{
  loopBody = loopBody_;
}

public String toString()
{
  return "for(" + init + ";" + condition + ";" + iterator + ")" + loopBody;
}
}
