public abstract class Node{
  
  Node parent;
  
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
}