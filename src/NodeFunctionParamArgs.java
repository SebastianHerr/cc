package src;

import src.bin.*;

import java.util.*;
public class NodeFunctionParamArgs extends Node
{

  ArrayList<Node> listOfParamters;
  
  public NodeFunctionParamArgs()
  {
    listOfParamters = new ArrayList<Node>();
  }
  
  public void addParameter(Node parameterType, Node parameterName)
  {
    parameterType.setParent(this);
    parameterName.setParent(this);
    listOfParamters.add(parameterType);
    listOfParamters.add(parameterName);
  }
  
  public NodeType getTypeOfNode(NodeIdentifier node)
  {
    int i = listOfParamters.indexOf(node);
    return (NodeType)listOfParamters.get(i-1);
  }

  public boolean compareNodeType(Node otherNode) throws TypeCheckingException
  {
    if(!(otherNode instanceof NodeFunctionParamArgs))
    {
    throw new TypeCheckingException();
    }
    
    boolean returnValue = true;
    
    for(int i = 0; i < listOfParamters.size(); i += 2) {
      returnValue &= listOfParamters.get(i).compareNodeType(((NodeFunctionParamArgs)otherNode).listOfParamters.get(i));
    }

    return returnValue;
  }

  public NodeType getNodeType()
  {
    return new NodeTypeVoid();
  }

  public boolean checkNodeType() throws TypeCheckingException
  {
    //TODO proper checking needed
    return true;
  }
  
  public String emitCode() throws CodeGenerationException
  {
    throw new CodeGenerationException();
  }

  public String toString(String indendation)
  {
    String result = "";
    for(int i = 0; i < listOfParamters.size(); i += 2) {
    if(i!=0) {
      result += ",";
    }
    result+= listOfParamters.get(i) + " " + listOfParamters.get(i+1);
   }
   return result;
  }
}