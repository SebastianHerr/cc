import java.util.*;
public class NodeBlock extends Node implements IScope{

int scopeID;

ArrayList<Node> statements;
Hashtable<String,NodeIdentifier> vidDefineList;

public NodeBlock(Token token_)
{
  super();
  scopeID = AppearanceTable.getNextScopeID();
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
  return locationInTable(nodeToGetIndexFrom, vidDefineList);
}

public IScope getContainingScope()
{
  return this;
}

public Node getNodeType()
{
  return new NodeTypeVoid();
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeBlock))
  {
    throw new TypeCheckingException();
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
  
public boolean checkNodeType() throws TypeCheckingException
{
  boolean returnValue = true;
  for(int i = 0; i<statements.size();i++)
  {
    returnValue &= statements.get(i).checkNodeType();
    if(!returnValue)
      return false;
  }
  return true;
}

public String emitCode() throws CodeGenerationException
{
  String result = "";
  for (Node statement : statements) {
    result += statement.emitCode();
  }
  return result;
}

public String toString(String indentation)
{
  String result = indentation + "{/* Scope ID = " +  scopeID + " */\n";
  
  //result += "/* \n\t\t<VIDLIST>" + vidDefineList + " </VIDLIST>@OFFSET=*/" + getParent().getContainingScope().getOffsetAfterLocalVidTable() + "\n";
  
  for (Node statement : statements) {
    result += indentation + standardIndentation + statement.toString(indentation + standardIndentation);
  }
  result += indentation + "}\n";
  return result;
}
}
