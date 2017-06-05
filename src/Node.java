public abstract class Node{
	public abstract String getNodeType();
	
	public abstract boolean checkNodeType();
	
	public abstract Node getParent();
	
	public abstract void setParent(Node newParent);
}