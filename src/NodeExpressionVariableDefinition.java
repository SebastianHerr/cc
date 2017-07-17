public class NodeExpressionVariableDefinition extends Node{

public Node type;
Node name;
Node assigment;

public NodeExpressionVariableDefinition(Node type_, Node name_)
{
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
}

public void setAssignment(Node assigment_)
{
  assigment = assigment_;
  assigment.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeExpressionVariableDefinition))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = type.compareNodeType(((NodeExpressionVariableDefinition)otherNode).type);
  returnValue &= name.compareNodeType(((NodeExpressionVariableDefinition)otherNode).name);
  returnValue &= assigment != null ? assigment.compareNodeType(((NodeExpressionVariableDefinition)otherNode).assigment) : true;

  return returnValue;
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public String toString(String indendation)
{
  return type.toString(indendation) + " " + name.toString(indendation) + (assigment != null ? "=" + assigment : "");
}

}
