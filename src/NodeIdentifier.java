import java.util.*;
public class NodeIdentifier extends Node{

int symbolID;
boolean isVDef = false;
boolean isFDef = false;
boolean isFCall = false;
boolean needsUpdate = true;
IdentifierType type ;

//Link to the NodeIdentifier of a function definition  or of a variable definition
Node definition;
//This List contains the usages of a variables, empty when it's no definition;
ArrayList<NodeIdentifier> usages;

public NodeIdentifier(Token token_, IdentifierType type_)
{
  token = token_;
  usages = new ArrayList<NodeIdentifier>();
  type = type_;
}

public Node getParent()
{
return parent;
}

public void setParent(Node newParent)
{
parent = newParent;
}

public void setSymbolID(int symbolID_)
{
  symbolID = symbolID_;
}

public int getSymbolID()
{
  return symbolID;
}

public void addUsage(NodeIdentifier node)
{
  //System.out.println("Added usage for " + token.image + getOccouranceLocation() + " at location " + node.getOccouranceLocation());
  usages.add(node);
  node.setDefintion(this);
}

public void setDefintion(Node definition_)
{
  definition = definition_;
}

public boolean isVariableDefinition()
{
  if(needsUpdate)
    updateDefinitions();
  return isVDef;
}

public boolean isFunctionDefinition()
{
  if(needsUpdate)
    updateDefinitions();
  return isFDef;
}

public boolean isFunctionCall()
{
  if(needsUpdate)
    updateDefinitions();
  return isFCall;
}

//Needs to be run once after the AST is built up completely
public void updateDefinitions()
{
  if(!needsUpdate)
  {
    return;
  }
  else
  {
    needsUpdate = false;
  }
  Node tmp = getParent();
  Node tmp2 = null;
  if(tmp == null)
  {
    System.out.println("PARENT NULL NEAR" + this + "@L" + token.beginLine + "C" + token.beginColumn);
  }
  /*else
  {
    System.out.println("Starting ascend up the tree for symbol" + token.image + ":");
  }*/
  
  //System.out.println(tmp.getClass());
  do
  {
    if((tmp instanceof NodeFunctionParamArgs) || (this.getParent() instanceof NodeExpressionVariableDefinition))
    {
      //System.out.println("\tToken \"" + token.image + "\"" + getOccouranceLocation() + " is a definition");
      isVDef = true;
    }
    else if(this.parent instanceof NodeFunction)
    {
      isFDef = true;
    }
    else if (this.parent instanceof NodeExpressionFunctionCall)
    {
      isFCall = true;
    }
    else
    {
      tmp2 = tmp.getParent();
      if(tmp2 == null)
      {
        System.out.println("NULL NEAR" + tmp  + "@L" + tmp.getToken().beginLine + "C" + tmp.getToken().beginColumn);
      }
      tmp=tmp2;
    }
    //System.out.println(tmp.getClass());
  }while((!isVDef && !isFDef && !isFCall) && !tmp.isRoot());
  
  //System.out.println("Done ascending up the tree, usage was " + (!isVDef?"not":"XXX") + " a defintition");
}

public String toString(String indendation)
{
  return token.image + "/* SyID " + symbolID + ";\t" + getOccouranceLocation() + "*/";
}
}
