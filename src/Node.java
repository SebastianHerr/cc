/**
 * This class allows you creating Nodes, adding children and printing
 * them to the console in a hierarchical way.
 *
 * @name Node
 * @author Konstantin Ruppel
 */
public class Node {
  public static String standardIndentation = ". ";

  C0Type type       = null;
  String image      = null;
  int beginLine     = -1;
  int beginColumn   = -1;
  int endLine       = -1;
  int endColumn     = -1;

  Node parent       = null;
  Node child        = null;
  Node sibling      = null;

  /**
   * Creates a new node.
   * @param token Token holding its status.
   */
  public Node (Token token) {
    this.type = C0Type.TERMINAL;
    this.beginLine = token.beginLine;
    this.endLine = token.endLine;
    this.beginColumn = token.beginColumn;
    this.endColumn = token.endColumn;
    this.image = token.image;
  }

  /**
   * Creates a new node and appends it to a given parent node.
   * @param type C0Type
   */
  public Node (C0Type type) {
    this.type = type;
  }

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
   * @param type C0Type
   */
  public void addChild (C0Type type) {
    this.addChild (new Node(type));
  }

  public void addChild (Token token) {
    this.addChild (new Node(token));
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

  /**
   * Prints the branch outgoing from this node to the console.
   * @param indentation Indentation on each layer.
   */
  public void printTree (String indentation) {
    if (this.type == C0Type.TERMINAL)
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