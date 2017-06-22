import java.util.*;
public class NodeRoot extends Node implements IScope{

ArrayList<Node> declarationsOrStatements;

int scopeID;

public NodeRoot()
{
  declarationsOrStatements = new ArrayList<Node>();
  scopeID = SymbolTable.getNextScopeID();
}

public String getNodeType()
{
return "NodeRoot";
}

public boolean checkNodeType()
{
return true; //Check okay
}

public boolean isRoot()
{
  return true;
}

public void addDeclarationOrStatement(Node node)
{
  declarationsOrStatements.add(node);
  node.setParent(this);
}

public String toString(String indendation)
{
  String result = "";
  for (Node declarationOrStatement : declarationsOrStatements) {
    result += declarationOrStatement.toString(indendation); //No identation for the members of the root
  }
  return result;
}

public int getScopeID()
{
  return scopeID;
}
}
