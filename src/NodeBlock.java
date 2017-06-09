import java.util.*;
public class NodeBlock extends Node{

ArrayList<Node> statements;

public NodeBlock()
{
  statements = new ArrayList<Node>();
}

public String getNodeType()
{
return "NodeBlock";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addStatement(Node node)
{
  statements.add(node);
  node.setParent(this);
}

public String toString()
{
  String result = "{";
  for (Node statement : statements) {
    result += statement;
  }
  result += "}";
  return result;
}
}
