public class NodeExpressionBrackets extends Node{

Node node;

public NodeExpressionBrackets(Node node_, Token token_)
{
  node = node_;
  node.setParent(this);
  token = token_;
}

public String getNodeType()
{
return "NodeExpressionBrackets";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public String toString(String indentation)
{
  return "(" + node.toString(indentation) + ")";
}
}
