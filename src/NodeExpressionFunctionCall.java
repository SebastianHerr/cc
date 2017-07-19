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

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionFunctionCall))
  {
    throw new TypeCheckingException();
  }
  boolean returnValue = name.compareNodeType(((NodeExpressionFunctionCall)otherNode).name);
  returnValue &= args.compareNodeType(((NodeExpressionFunctionCall)otherNode).args);

  return returnValue;
}

public Node getNodeType()
{
  return name.getNodeType();
}

public boolean checkNodeType() throws TypeCheckingException
{
  //TODO proper check for types
  return true;
}
  
public String emitCode() throws CodeGenerationException
{
  String result = args.emitCode();
  result += "mark\n";
  result += "loadc _" + name.getToken().image + "\n";
  result += "call\n";
  result += "slide 0\n"; //TODO find correct value for 0
  return result;
}

public String toString(String indendation)
{
  return name.toString(indendation) + "(" + args.toString(indendation) + ")";
}
}
