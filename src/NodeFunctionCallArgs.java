package src;

import src.bin.*;

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

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeFunctionCallArgs))
  {
    throw new TypeCheckingException();
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

public boolean checkNodeType() throws TypeCheckingException
{
  //TODO proper checking needed
  return true;
}
  
public String emitCode() throws CodeGenerationException
{
  String result = "";
  for(int i = arguments.size(); i > 0; i -= 2) {
    result += arguments.get(i).emitCode();
  }
  return result;
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
