public class NodeExpressionVariableDefinition extends Node{

Node type;
Node name;
Node assigment;

public NodeExpressionVariableDefinition(Node type_, Node name_)
{
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
}

public String getNodeType()
{
return "NodeExpressionVariableDefinition";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void setAssignment(Node assigment_)
{
  assigment = assigment_;
  assigment.setParent(this);
}

public String toString(String indendation)
{
  return type.toString(indendation) + " " + name.toString(indendation) + (assigment != null ? "=" + assigment : "");
}

}
