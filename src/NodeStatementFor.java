public class NodeStatementFor extends Node{

Node init;
Node condition;
Node iterator;
Node loopBody;

public NodeStatementFor(Token token_)
{
  token = token_;
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

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeStatementFor))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  NodeStatementFor otherNodeTyped = (NodeStatementFor) otherNode;
  boolean returnValue = init.compareNodeType(otherNodeTyped.init);
  returnValue &= condition.compareNodeType(otherNodeTyped.condition);
  returnValue &= iterator.compareNodeType(otherNodeTyped.iterator);
  returnValue &= loopBody.compareNodeType(otherNodeTyped.loopBody);
  return returnValue;
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public String toString(String indendation)
{
  //Init and Iterator are optional
  return "for(" + (init != null ? init.toString(indendation) : "") + ";" + condition.toString(indendation) + ";" + (iterator != null ? iterator.toString(indendation) : "") + ")\n" + loopBody.toString(indendation);
}
}
