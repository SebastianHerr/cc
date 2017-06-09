import java.util.*;
public class NodeRoot extends Node{

ArrayList<Node> declarationsOrStatements;

public NodeRoot()
{
  declarationsOrStatements = new ArrayList<Node>();
}

public String getNodeType()
{
return "NodeRoot";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public void addDeclarationOrStatement(Node node)
{
  declarationsOrStatements.add(node);
  node.setParent(this);
}

public String toString()
{
  String result = "";
  for (Node declarationOrStatement : declarationsOrStatements) {
    result += declarationOrStatement + "\n";
  }
  return result;
}
}
