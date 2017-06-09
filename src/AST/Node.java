/**
 * This class allows you creating Nodes, adding children and printing
 * them to the console in a hierarchical way.
 *
 * @name Node
 * @author Konstantin Ruppel
 */
public class Node {

  public static String standardIndentation = ". ";
  String image = null;
  Node parent = null;
  Node child = null;
  Node sibling = null;

  // Position in source file
  int beginLine;
  int beginColumn;
  int endLine;
  int endColumn;

  public Node (String image) {
    this.image = image;
  }

  public Node (Token token) {
    this.image = token.image;
    this.beginLine = token.beginLine;
    this.beginColumn = token.beginColumn;
    this.endColumn = token.endColumn;
    this.endLine = token.endLine;
  }

  public Node (Token token, Node parent) {
    this (token);
    parent.addChild (this);
  }

  /***************************************************************************/

  /**
   * Adds a new child. If this is not the first child, it will become a sibling
   * of the child or the siblings sibling of the child and so on.
   * @param child Child node.
   */
  public void addChild (Node child) {
    if (this.child == null) {
      this.child = child;
      this.child.parent = this;
    } else {
      this.child.addSibling (child);
    }
  }

  /**
   * Appends a new child node representing the given value.
   * @param value String representation of this node.
   */
  public void addChild (Token token) {
    addChild (new Node(token));
  }

  /**
   * Adds a new sibling and sets its parent to the current Nodes parent.
   * @param sibling Sibling node.
   */
  public void addSibling (Node sibling) {
    if (this.sibling == null) {
      this.sibling = sibling;
      this.sibling.parent = this.parent;
    } else {
      this.sibling.addSibling (sibling);
    }
  }

  /***************************************************************************/

  /**
   * Prints the branch outgoing from this node to the console.
   * @param indentation Indentation on each layer.
   */
  public void printTree (String indentation) {
    System.out.println (indentation + this.image);
    if (this.child != null) {
      this.child.printTree (standardIndentation + indentation);
    }
    if (this.sibling != null) {
      this.sibling.printTree (indentation);
    }
  }

  /**
   * Calls printTree with no indentation for the starting node.
   */
  public void printTree () {
    printTree("");
  }

  /**
   * Gets the root node recursively.
   * @return Root node.
   */
  public Node getRoot () {
    if (this.parent == null) {
      return this;
    } else {
      return this.parent.getRoot();
    }
  }

  @Override
  public String toString () {
    return this.image;
  }
}