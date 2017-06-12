import java.util.*;
public class NodeStructDefinition extends Node{

NodeStructSignature name;

ArrayList<Node> listOfMembers;

public NodeStructDefinition(NodeStructSignature name_)
{
  name = name_;
  name.setParent(this);
  listOfMembers = new ArrayList<Node>();
}

public String getNodeType()
{
return "NodeStructDefinition";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addElement(Node type_, Node name_)
{
  type_.setParent(this);
  name_.setParent(this);
  listOfMembers.add(type_);
  listOfMembers.add(name_);
}

public String toString(String indendation)
{
  String result = name.toString(indendation) + "{\n";
  for(int i = 0; i < listOfMembers.size(); i += 2) {
    result+= indendation + listOfMembers.get(i).toString(indendation) + "" + listOfMembers.get(i+1).toString(indendation) + ";\n";
  }
  result += indendation + "}\n";
  return result;
}
}
