public class NodeIdentifier extends Node{

int symbolID;

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


public String toString(String indendation)
{
  return token.image + "/* SyID " + symbolID + "*/";
}
}
