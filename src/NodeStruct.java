import java.util.*;
public class NodeStruct extends Node implements IScope{

NodeIdentifier name;
int scopeID;

ArrayList<Node> listOfMembers;


NodeStruct structLink;

public NodeStruct(NodeIdentifier name_)
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

public boolean isDefinition()
{
  return listOfMembers.size() > 0;
}

public boolean isDefined()
{
  return isDefinition() || (structLink != null ? structLink.isDefinition() : false);
}

public void setStrucLinkLink(NodeStruct structLink_)
{
  if(isDefined())
  {
    //Should never be reached unless i made a stupid programming mistake :)
    System.out.println("This can only be changed when there isn't already a definition");
  }
  
  structLink = structLink_;
}

public NodeStruct getStructLink()
{
  if(isDefinition())
  {
    return this;
  }
  else
  {
    return structLink;
  }
}

public int getScopeID()
{
  return scopeID;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  //No functions and variables can be defined inside a struct, caller needs to check for null
  return null;
}

public int getOffsetAfterLocalVidTable()
{
  return 0;
}

public IScope getContainingScope()
{
  return this;
}

public String toString(String indendation)
{
  String result = "struct " + name.toString(indendation) + " /* Scope ID = " +  scopeID + " */" ;
  if (listOfMembers.size() !=0)
  {   
    result += "{\n";
    for(int i = 0; i < listOfMembers.size(); i += 2) {
      result+= indendation + listOfMembers.get(i).toString(indendation) + "" + listOfMembers.get(i+1).toString(indendation) + ";\n";
    }
    result += indendation + "}";
  }
  
  result += ";\n";
  
  return result;
}
}
