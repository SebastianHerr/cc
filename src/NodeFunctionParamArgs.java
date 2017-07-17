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

  public boolean compareNodeType(Node otherNode)
  {
    if(!(otherNode instanceof NodeFunctionParamArgs))
  {
    Thread.dumpStack();
		System.out.println(this.getClass());
		return false;
    }
    
    boolean returnValue = true;
    
    for(int i = 0; i < listOfParamters.size(); i += 2) {
      returnValue &= listOfParamters.get(i).compareNodeType(((NodeFunctionParamArgs)otherNode).listOfParamters.get(i));
    }

    return returnValue;
  }

  public Node getNodeType()
  {
    return new NodeTypeVoid();
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