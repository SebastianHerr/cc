import java.util.*;
public class NodeFunctionCallArgs extends Node{

ArrayList<Node> arguments;

public NodeFunctionCallArgs()
{
  arguments = new ArrayList<Node>();
}

public void addArg(Node argument)
{
  arguments.add(argument);
  argument.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeFunctionCallArgs))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  
  boolean returnValue = true;
  
  for(int i = 0; i < arguments.size(); i += 2) {
    returnValue &= arguments.get(i).compareNodeType(((NodeFunctionCallArgs)otherNode).arguments.get(i));
  }

  return returnValue;
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public String toString(String indendation)
{
  String result = "";
  boolean firstLoop = true;
  for (Node argument : arguments) {
    if(firstLoop)
    {
      firstLoop = !firstLoop;
    }
    else
    {
      result += ",";
    }
    result += argument.toString(indendation) ;
  }
  return result;
}
}
