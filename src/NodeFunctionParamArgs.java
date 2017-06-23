import java.util.*;
public class NodeFunctionParamArgs extends Node
{

  ArrayList<Node> listOfParamters;
  
  public NodeFunctionParamArgs()
  {
    listOfParamters = new ArrayList<Node>();
  }
  
  public String getNodeType()
  {
    return "NodeFunctionParamArgs";
  }

  public boolean checkNodeType()
  {
    return true; //Check okay
  }
  
  public void addParameter(Node parameterType, Node parameterName)
  {
    parameterType.setParent(this);
    parameterName.setParent(this);
    listOfParamters.add(parameterType);
    listOfParamters.add(parameterName);
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