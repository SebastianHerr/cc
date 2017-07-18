public class NodeExpressionAlloc extends Node{

Node type;

public NodeExpressionAlloc(Node type_, Token token_)
{
  type = type_;
  token = token_;
  type.setParent(this);
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}

public Node getNodeType()
{
  return new NodeTypePointer(new NodeTypeInt());
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionAlloc))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return type.compareNodeType(((NodeExpressionAlloc)otherNode).type);
}
  
public boolean checkNodeType()
{
  return true; //Nothing to check here, the parser makes sure that the given node is already a type
}

public String toString(String indendation)
{
  return "alloc(" + type.toString(indendation) + ")";
}
}
