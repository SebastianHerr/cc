public class NodeIdentifier extends Node{

int symbolID;
boolean isVDef = false;
boolean isFDef = false;
boolean needsUpdate = true;

public NodeIdentifier(Token token_)
{
  token = token_;
}

public String getNodeType()
{
return "NodeIdentifier";
}

public boolean checkNodeType()
{
return true; //Check okay
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

//Needs to be run once after the AST is built up completely
public void updateDefinitions()
{
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
  
  System.out.println(tmp.getClass());
  do
  {
    if((tmp instanceof NodeExpressionVariableDefinition) | (tmp instanceof NodeFunctionParamArgs))
    {
      isVDef = true;
    }
    else if(tmp instanceof NodeFunctionSignature)
    {
      isFDef = true;
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
  }while((!isVDef && !isFDef) && !tmp.isRoot());
  
  //System.out.println("Done ascending up the tree, usage was " + (!isVDef?"not":"XXX") + " a defintition");
}

public String toString(String indendation)
{
  return token.image + "/* SyID " + symbolID + "*/";
}
}
