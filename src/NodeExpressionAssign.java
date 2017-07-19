public class NodeExpressionAssign extends NodeExpressionBinary{

public NodeExpressionAssign(Node primary_)
{
  super(primary_);
}

public Node getNodeType()
{
  return primary.getNodeType();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  //Both sides need to be the same, no futher conditions
  if(!(primary.getNodeType().compareNodeType(secondary.getNodeType())))
  {
    return false;
  }
  return primary.checkNodeType() && secondary.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  String result = secondary.emitCode();
  result += primary.emitCode();
  result += "store\n";
  return result;
}
}
