public class NodeTypeStruct extends Node{

Node name;

public NodeTypeStruct(Node name_)
{
  name = name_;
  name.setParent(this);
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeTypeStruct))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  return name.compareNodeType(((NodeTypeStruct)otherNode).name);
}

public Node getNodeType()
{
  return this;
}

public String toString(String indendation)
{
  return "struct " + name.toString(indendation);
}
}
