package src;

import src.bin.*;

import java.util.*;
public class NodeRoot extends Node implements IScope{

ArrayList<Node> declarationsOrDefinitions;

int scopeID;
  //Definitions at each scope possible
  AppearanceTable vidTable;
  //Definitions only possible at root scope
  AppearanceTable sidTable;
  //Definitions only possible inside struct definitions
  AppearanceTable fidTable;
  
  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeRoot()
{
  super();
  declarationsOrDefinitions = new ArrayList<Node>();
  scopeID = AppearanceTable.getNextScopeID();
  vidDefineList = new Hashtable<String,NodeIdentifier>();
}

public boolean isRoot()
{
  return true;
}

  public NodeRoot getRoot()
  {
    return this;
  }

public void addDeclarationOrDefinition(Node node)
{
  declarationsOrDefinitions.add(node);
  node.setParent(this);
}


public void addSymbolTables(AppearanceTable vidTable_, AppearanceTable sidTable_, AppearanceTable fidTable_)
{
  //Update only new tables
  vidTable = vidTable_ != null ? vidTable_ : vidTable;
  sidTable = sidTable_ != null ? sidTable_ : sidTable;
  fidTable = fidTable_ != null ? fidTable_ : fidTable;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  return vidDefineList;
}

public NodeIdentifier getMainMethod()
{
  return getListOfVidDefines().get("main");
}

public int getOffsetAfterLocalVidTable()
{
  return 0;
}

public int locationInTable(NodeIdentifier nodeToGetIndexFrom)
{
  //TODO maybe return location of a function in the code memory?
  return 0;
}

public IScope getContainingScope()
{
  return this;
}

public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeRoot))
  {
    throw new TypeCheckingException();
  }
  
  boolean returnValue = true;
  for (int i = 0; i<declarationsOrDefinitions.size();i++) {
    returnValue &= declarationsOrDefinitions.get(i).compareNodeType(((NodeRoot)otherNode).declarationsOrDefinitions.get(i)); 
  }
  return returnValue;
}

public boolean checkNodeType() throws TypeCheckingException
{
  boolean returnValue = true;
  //Check if main function is an int or void
  getMainMethod().getNodeType();
  for (int i = 0; i<declarationsOrDefinitions.size();i++) {
    returnValue &= declarationsOrDefinitions.get(i).checkNodeType(); 
  }
  return returnValue;
}

public NodeType getNodeType()
{
  return new NodeTypeVoid();
}

public String emitCode() throws CodeGenerationException
{
  if(getMainMethod() == null)
  {
    throw new CodeGenerationException("Missing main function");
  }   
  String result = "enter 4\n";
  result += "alloc 1\n";
  result += "mark\n";
  result += "loadc _main\n";
  result += "call\n";
  result += "halt\n";
  
  for (Node declarationOrdefinition : declarationsOrDefinitions) 
  {
    if(declarationOrdefinition != null && declarationOrdefinition instanceof NodeFunction)
    {
      result += declarationOrdefinition.emitCode();    
    }
    
  }
  
  return result;
}

public String toString(String indendation)
{
  String result = "";
  for (Node declarationOrdefinition : declarationsOrDefinitions) {
    result += declarationOrdefinition.toString(indendation); //No identation for the members of the root
  }
  return result;
}

public int getScopeID()
{
  return scopeID;
}
}
