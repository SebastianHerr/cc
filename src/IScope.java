import java.util.*;
public interface IScope
{
  public int getScopeID();
  
  public Hashtable<String, NodeIdentifier> getListOfVidDefines();
  
  //Below some functions of the class Node which all IScope nodes should already have
  public IScope getContainingScope();
  
  public void addSubscope(IScope node);
}

/* 
 * Implemented by:
 * NodeBlock
 * NodeFunction
 * NodeRoot
 * NodeStructSignature
 */