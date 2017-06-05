/**
 * This class allowes you creating Nodes, adding children and prining
 * them to the console in a hierarchical way.
 *
 * @name Node
 * @author Konstantin Ruppel
 */
public class Node {
  static String standardIndentation = "  ";
  String image = null;
  Node parent = null;
  Node child = null;
  Node sibling = null;

  public Node (String image) {
    this.image = image;
  }

  public Node (String image, Node parent) {
    this.image = image;
    parent.addChild(this);
  }

  /**
   * Adds a new child. If this is not the first child, it will become a sibling
   * of the child or the siblings sibling of the child and so on.
   */
  public void addChild (Node child) {
    if (this.child == null) {
      this.child = child;
      this.child.parent = this;
    } else {
      this.child.addSibling (child);
    }
  }

  public void addChild (String value) {
    addChild(new Node(value));
  }

  /**
   * Adds a new sibling and sets its parent to the current Nodes parent.
   */
  public void addSibling (Node sibling) {
    if (this.sibling == null) {
      this.sibling = sibling;
      this.sibling.parent = this.parent;
    } else {
      this.sibling.addSibling (sibling);
    }
  }

  public void printTree (String indentation) {
    System.out.println(indentation + this.image);

    if (this.child != null) {
      this.child.printTree(indentation + standardIndentation);
    }
    if (this.sibling != null) {
      this.sibling.printTree (indentation);
    }
  }

  @Override
  public String toString () {
    return this.image;
  }
}