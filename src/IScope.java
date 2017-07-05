import java.util.*;
public interface IScope
{
  public int getScopeID();
  
  public Hashtable<String, NodeIdentifier> getListOfVidDefines();
  
  //Below some functions of the class Node which all IScope nodes should already have
  public IScope getContainingScope();
  
  public void addSubscope(IScope node);
  
  /*
   * Return the offset of the vidtable, relativ to the location of the table of a function
   */
  public int getOffsetAfterLocalVidTable();
}

/* 
 * Implemented by:
 * NodeBlock
 * NodeFunction
 * NodeRoot
 * NodeStructSignature
 */