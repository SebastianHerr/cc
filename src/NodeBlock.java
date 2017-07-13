import java.util.*;
public class NodeBlock extends Node implements IScope{

int scopeID;

ArrayList<Node> statements;
Hashtable<String,NodeIdentifier> vidDefineList;

public NodeBlock(Token token_)
{
  super();
  scopeID = SymbolTable.getNextScopeID();
  token = token_;
  statements = new ArrayList<Node>();
  vidDefineList = new Hashtable<String,NodeIdentifier>();
}

public void addStatement(Node node)
{
  statements.add(node);
  node.setParent(this);
}


public int getScopeID()
{
  return scopeID;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  return vidDefineList;
}

public int getOffsetAfterLocalVidTable()
{
  int size = getParent().getContainingScope().getOffsetAfterLocalVidTable();
  for(Node node: vidDefineList.values())
  {
    size += node.getTypeSize();
  }
  return size;
}

public int locationInTable(NodeIdentifier nodeToGetIndexFrom)
{
  int index = 0;
  for(NodeIdentifier node: vidDefineList.values())
  {
    if(nodeToGetIndexFrom == node)
    {
      break;
    }
    else
    {
      index += node.getTypeSize();
    }
  }
  return index;
}

public IScope getContainingScope()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeBlock))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  boolean returnValue = true;
  for(int i = 0; i<statements.size();i++)
  {
    Node thisSubNode = statements.get(i);
    Node otherSubNode = ((NodeBlock)otherNode).statements.get(i);
    returnValue &= thisSubNode.compareNodeType(otherSubNode);
    if(!returnValue)
      return false;
  }
  return true;
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
}
