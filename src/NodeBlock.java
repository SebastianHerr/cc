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

public String toString(String indentation)
{
  String result = indentation + "{\n";
  for (Node statement : statements) {
    result += indentation + standardIndentation + statement.toString(indentation + standardIndentation);
  }
  result += indentation + "}\n";
  return result;
}
}
