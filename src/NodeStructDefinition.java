import java.util.*;
public class NodeStructDefinition extends Node{

NodeStructSignature name;

ArrayList<Node> listOfMembers;

public NodeStructDefinition(NodeStructSignature name_)
{
  name = name_;
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
  listOfMembers.add(type_);
  listOfMembers.add(name_);
}

public String toString()
{
  String result = name + "{";
  for(int i = 0; i < listOfMembers.size(); i += 2) {
    result+= listOfMembers.get(i) + "" + listOfMembers.get(i+1) + ";";
  }
  result += "}";
  return result;
}
}
