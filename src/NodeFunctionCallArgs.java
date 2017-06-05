import java.util.*;
public class NodeFunctionCallArgs{

ArrayList<Node> arguments;

public NodeFunctionCallArgs()
{
  arguments = new ArrayList<Node>();
}

public String getNodeType()
{
return "NodeFunctionCallArgs";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addArg(Node argument)
{
  arguments.add(argument);
}

public String toString()
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
    result += argument;
  }
  return result;
}
}
