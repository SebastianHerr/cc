public abstract class Node{
  
  Node parent = null;
  
  Node root = null;
  
  Node enclosingBlock = null;
  
  Token token = null;
  
  public static String standardIndentation = "  ";
  
	public abstract String getNodeType();
	
	public abstract boolean checkNodeType();
	
	public Node getParent()
  {
    return parent;
  }
	
	public void setParent(Node parent_)
  {
    parent = parent_;
  }
  
  public void setRoot(Node root_)
  {
    root = root_;
  }
  
  public Node getRoot()
  {
    if (root == null)
    {
      root = parent.getRoot();
    }
    return root;
  }
  
  public void setEnclosingBlock(Node enclosingBlock_)
  {
    enclosingBlock = enclosingBlock_;
  }
  
  public Node getEnclosingBlock()
  {
    if(enclosingBlock == null)
    {
      enclosingBlock = parent.getEnclosingBlock();
    }
    return enclosingBlock;
  }
  
  public abstract String toString(String indendation);
  
  public String toString()
  {
    return toString("");
  }
  
  // Returns the token which defined this Node when this is a leaf, otherwise it returns null
  public Token getToken()
  {
    return token;
  }
}