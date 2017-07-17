public class NodeExpressionFunctionCall extends Node{

Node name; 
NodeFunctionCallArgs args;

public NodeExpressionFunctionCall(Node name_, NodeFunctionCallArgs args_)
{
  name = name_;
  name.setParent(this);
  args = args_;
  args.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionFunctionCall))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = name.compareNodeType(((NodeExpressionFunctionCall)otherNode).name);
  returnValue &= args.compareNodeType(((NodeExpressionFunctionCall)otherNode).args);

  return returnValue;
}

public Node getNodeType()
{
  return name.getNodeType();
}

public String toString(String indendation)
{
  return name.toString(indendation) + "(" + args.toString(indendation) + ")";
}
}
