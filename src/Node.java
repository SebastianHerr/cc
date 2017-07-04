import java.util.*;
public abstract class Node{
  
  Node parent = null;
  
  NodeRoot root = null;
  
  Token token = null;
  
  public static String standardIndentation = "  ";
  
	public abstract String getNodeType();
	
	public abstract boolean checkNodeType();
  //This list is only ever initialized when this is an implementation of IScope
  ArrayList<IScope> subscopes;
  
  public Node()
  {
    if(this instanceof IScope)
    {
      subscopes = new ArrayList<IScope>();
    }
  }
	
	public Node getParent()
  {
    return parent;
  }
	
	public void setParent(Node parent_)
  {
    parent = parent_;
  }
  
  public NodeRoot getRoot()
  {
    if (root == null)
    {
      root = parent.getRoot();
    }
    return root;
  }
  
  public boolean isRoot()
  {
    return false;
  }
  
  public boolean isBelowInTree(Node child)
  {
    if(child.isRoot())
    {
      //Root can't be the child of anything
      return false;
    }
    
    while(child != this)
    {
      child = child.getParent();
      if(child == null)
      {
        return false;
      }
      else if(child == this)
      {
        return true;
      }
    }
    //Can only be reached if the node child is a reference to this node
    return true;
  }
  
  /*
   * Returns the scope in which this node is contained.
   * null if it's the root node
   */
  public IScope getContainingScope()
  {
    return parent.getContainingScope();
  }
  
  /*
   * Place the definition of this method here, since all IScope Members need to be a subtype of Node
   */
  public void addSubscope(IScope scope)
  {
    if(this instanceof IScope)
    {
      if(!subscopes.contains(scope))
      {
        subscopes.add(scope);
      }
    }
  }
   
  public ArrayList<IScope> getSubscopes()
  {
    if(this instanceof IScope)
    {
      return subscopes;
    }
    System.out.println("Called getSubscopes on a non IScope node");
    return null;
  }
  
  public String getOccouranceLocation()
  {
    return "@L" + token.beginLine + "C" + token.beginColumn;
  }
  
  public abstract String toString(String indendation);
  
  public String toString()
  {
    return toString("");
  }
  
  /*
    Returns the token which defined this Node when this is a leaf. 
    If this node is an operator, then it shows to the operator or 
    the first one if there are several operator symbols are existant.
   */
  public Token getToken()
  {
    return token;
  }
}