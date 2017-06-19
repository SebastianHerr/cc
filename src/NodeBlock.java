import java.util.*;
public class NodeBlock extends Node implements IScope{

private static int runningID = 1;
int scopeID;

ArrayList<Node> statements;

public NodeBlock(Token token_)
{
  scopeID = SymbolTable.getNextScopeID();
  token = token_;
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
  String result = indentation + "{/* Scope ID = " +  scopeID + " */\n";
  for (Node statement : statements) {
    result += indentation + standardIndentation + statement.toString(indentation + standardIndentation);
  }
  result += indentation + "}\n";
  return result;
}

public int getScopeID()
{
  return scopeID;
}
}
