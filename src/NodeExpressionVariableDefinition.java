package src;

import src.bin.*;

public class NodeExpressionVariableDefinition extends Node{

public NodeType type;
NodeIdentifier name;
Node assigment;

public NodeExpressionVariableDefinition(NodeType type_, NodeIdentifier name_)
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

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeExpressionVariableDefinition))
  {
    throw new TypeCheckingException();
  }
  boolean returnValue = type.compareNodeType(((NodeExpressionVariableDefinition)otherNode).type);
  returnValue &= name.compareNodeType(((NodeExpressionVariableDefinition)otherNode).name);
  returnValue &= assigment != null ? assigment.compareNodeType(((NodeExpressionVariableDefinition)otherNode).assigment) : true;

  return returnValue;
}

public NodeType getNodeType()
{
  return new NodeTypeVoid();
}

public boolean checkNodeType() throws TypeCheckingException
{
  if(assigment != null)
  {
    if (!type.compareNodeType(assigment.getNodeType()) || !assigment.checkNodeType())
    {
      return false;
    }
  }
  return name.checkNodeType();
}

public String emitCode() throws CodeGenerationException
{
  if(assigment != null)
  {
    String result = assigment.emitCode();
    result += "storea " + name.getStackAdress() + "\n";
    return result;
  }
  else
  {
    return "";
  }
}

public String toString(String indendation)
{
  return type.toString(indendation) + " " + name.toString(indendation) + (assigment != null ? "=" + assigment : "");
}

}
