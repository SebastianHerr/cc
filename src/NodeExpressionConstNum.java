public class NodeExpressionConstNum extends Node{

int value;

public NodeExpressionConstNum(Token token_)
{
  token = token_;
  value = Integer.parseInt(token.image);
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeTypeInt || otherNode instanceof NodeExpressionConstNum))
  {
    throw new TypeCheckingException();
  }
  return true;
}

public Node getNodeType()
{
  return new NodeTypeInt();
}
  
public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public String emitCode() throws CodeGenerationException
{
  return "loadc " + value + "\n";
}

public String toString(String indendation)
{
  return value + "";
}
}
