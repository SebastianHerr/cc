package src;

import src.bin.*;

import java.util.*;
public class NodeIdentifier extends Node implements IAssignable{

int symbolID;
boolean isVDef = false;
boolean isFDef = false;
boolean isFCall = false;
boolean needsUpdate = true;
IdentifierType type ;

//Link to the NodeIdentifier of a function definition  or of a variable definition
NodeIdentifier definition;
//This List contains the usages of a variables, empty when it's no definition;
ArrayList<NodeIdentifier> usages;

public NodeIdentifier(Token token_, IdentifierType type_)
{
  token = token_;
  usages = new ArrayList<NodeIdentifier>();
  type = type_;
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

public void setDefintion(NodeIdentifier definition_)
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


public boolean compareNodeType(Node otherNode) throws TypeCheckingException
{
  if(!(otherNode instanceof NodeIdentifier))
  {
    throw new TypeCheckingException();
  }
  
  if(type == IdentifierType.VID && (isVDef || isFDef || isFCall))
  {
    return definition.compareNodeType(((NodeIdentifier)otherNode).definition);
  }
  else if(type == IdentifierType.FID && ((NodeIdentifier)otherNode).type == IdentifierType.FID)
  {
    //Thread.dumpStack();
		//System.out.println(this.getClass() + "\t" + otherNode.getClass());
    return true;
  }
  else if(type == IdentifierType.SID && ((NodeIdentifier)otherNode).type == IdentifierType.SID)
  {
    //Thread.dumpStack();
		//System.out.println(this.getClass() + "\t" + otherNode.getClass());
    return true;
  }
  else
  {
    //Something is odd here, should never be reached
    return false;
  }
}

public NodeType getNodeType()
{
  if(!(isVDef || isFDef || isFCall))
  {
    return definition.getNodeType();
  }
  else if(type == IdentifierType.VID)
  {
    //Here this node can be the definition of a variable or a function
    if(isVDef)
    {
      if(getParent() instanceof NodeExpressionVariableDefinition)
      {
        return ((NodeExpressionVariableDefinition)getParent()).type;
      }
      else
      {
        return ((NodeFunctionParamArgs)getParent()).getTypeOfNode(this);
      }
    }
    else if(isFDef)
    {
      return ((NodeFunction)getParent()).type;
    }
    else if(isFCall)
    {
      return definition.getParent().getNodeType();
    }
  }
  else if(type == IdentifierType.FID)
  {
    //TODO implement for fields
    return null;
  }
  else if(type == IdentifierType.SID)
  {
    //TODO implement for structs
    return null;    
  }
  else
  {
    //Should never be reached
    return null;
  }
  System.out.println("ERROR");
  System.out.println(isVDef);
  System.out.println(isFDef);
  System.out.println(isFCall);
  System.out.println(type);
  
  //TODO remove
  return null;
}

public boolean checkNodeType() throws TypeCheckingException
{
  return true;
}

public int getStackAdress()
{
  return getContainingScope().locationInTable(definition != null ? (definition) : this);
}
  
//Loads the value of this variable onto the stack, use getStackAdress to get the adress of this node
public String emitCode() throws CodeGenerationException
{
  return "loadc " + getStackAdress() + "\n" + "load 1\n";
}

boolean isprinting = false;
public String toString(String indendation)
{
  /* Just commented out code to see what some internal values are
  String testing = "";
  if(isprinting)
  { 
    testing += "";
  }
  else
  {
     isprinting = true;
     
     testing += getContainingScope().locationInTable(definition != null ? (definition) : this) + (definition == null ? "D" : "O");
     isprinting = false;
  }*/
  return token.image;// + "|-" + testing + "-|";// + "/* SyID " + symbolID + ";\t" + getOccouranceLocation() + "*/";
}
}
