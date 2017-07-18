import java.util.*;
public class NodeFunction extends Node implements IScope{

Node type;
NodeIdentifier name;
NodeFunctionParamArgs params;

NodeBlock nodeFunctionCode;

NodeFunction functionLink;
ArrayList<NodeStatementReturn> returnNodes;

int scopeID;

  //Definition of functions in this scope
  Hashtable<String,NodeIdentifier> vidDefineList;

public NodeFunction(Node type_, NodeIdentifier name_)
{
  super();
  scopeID = SymbolTable.getNextScopeID();
  type = type_;
  type.setParent(this);
  name = name_;
  name.setParent(this);
  vidDefineList = new Hashtable<String,NodeIdentifier>();
  returnNodes = new ArrayList<NodeStatementReturn>();
}

public void addParameters(NodeFunctionParamArgs params_)
{
  params = params_;
  params.setParent(this);
}

public void setFunctionCodeBlock(NodeBlock nodeFunctionCode_)
{
  nodeFunctionCode = nodeFunctionCode_;
  nodeFunctionCode.setParent(this);
}

public void addReturnStatement(NodeStatementReturn node)
{
  returnNodes.add(node);
}

public NodeIdentifier getName()
{
  return name;
}

public boolean isDefinition()
{
  return nodeFunctionCode != null;
}

public boolean isDefined()
{
  return isDefinition() || (functionLink != null ? functionLink.isDefinition() : false);
}

public void setFunctionLink(NodeFunction functionLink_)
{
  if(isDefined())
  {
    //Should never be reached unless i made a stupid programming mistake :)
    System.out.println("This can only be changed when there isn't already a definition");
  }
  
  functionLink = functionLink_;
}

public NodeFunction getFunctionLink()
{
  if(isDefinition())
  {
    return this;
  }
  else
  {
    return functionLink;
  }
}


public int getScopeID()
{
  return scopeID;
}

public Hashtable<String,NodeIdentifier> getListOfVidDefines()
{
  return vidDefineList;
}

public int locationInTable(NodeIdentifier nodeToGetIndexFrom)
{
  return locationInTable(nodeToGetIndexFrom, vidDefineList);
}

public int getOffsetAfterLocalVidTable()
{
  //Local variables start at index 1 according to Chapter 5 Code Generation 2 Slide 13
  return 1;
}

public int getSizeOfFormalParameters()
{
  int size = 0;
  for(Node node: vidDefineList.values())
  {
    size += node.getTypeSize();
  }
  return size;
}

public IScope getContainingScope()
{
  return this;
}

public boolean compareNodeType(Node otherNode)
{
  if(!(otherNode instanceof NodeFunction))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
  }
  NodeFunction otherNodeCast = (NodeFunction)otherNode;
  NodeFunction thisNode = getFunctionLink();
  boolean returnValue = true;
  
  returnValue &= thisNode.type.compareNodeType(otherNodeCast.type);
  returnValue &= thisNode.params.compareNodeType(otherNodeCast.params);

  return returnValue;
}

public Node getNodeType()
{
  return type;
}

public boolean checkNodeType()
{
  //Check if the delcarions and the definition match up
  if(functionLink != null)
  {
    functionLink.compareNodeType(this);
  }
  return params.checkNodeType() && (nodeFunctionCode!= null ? nodeFunctionCode.checkNodeType() : true);
}

public String toString(String indendation)
{
  String result = type + " " + name + "(";
  result += params;
  result += ") /* Scope ID = " +  scopeID + " */";
  
  //result += "/* \n\t\t<VIDLIST>" + vidDefineList + " </VIDLIST>@OFFSET=*/" + getParent().getContainingScope().getOffsetAfterLocalVidTable() + "\n";
  
  if(nodeFunctionCode == null)
  {
    result += ";\n";
  }
  else
  {
     result += "\n" + nodeFunctionCode.toString(indendation);
  }
  return result;
}
}
