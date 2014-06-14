/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class DList {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected int size;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new DListNode(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
    //  Your solution here.
    head = newNode(0,null,null);
    head.next = head.prev = head;
    size = 0;
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise.
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  length() returns the length of this DList.
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
    // Your solution here.
      if( head!=null ) {
          DListNode node = newNode( item, head, head.next);
          head.next.prev = node;
          head.next = node;
          ++size;
      }
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
    // Your solution here.
      if( head!=null ) {
          DListNode node = newNode( item, head.prev, head);
          head.prev.next = node;
          head.prev = node;
          ++size;
      }
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode front() {
    // Your solution here.
    if( head.next == head ) return null;
    return head.next;
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode back() {
    // Your solution here.
    if( head.prev == head ) return null;
    return head.prev;
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode next(DListNode node) {
    if( node == null || node.next==head ) return null;
    return node.next;
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev(DListNode node) {
    if( node == null || node.prev==head ) return null;
    return node.prev;
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNode node) {
    // Your solution here.
    if( node==null || node.prev==null | node.next==null ) {
    } else {
        DListNode t1 = this.next(node);
        DListNode t2;
        t2 = newNode(item, node, t1);
        t1.prev = t2;
        node.next = t2;
        ++size;
    }
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNode node) {
    // Your solution here.
    if( node==null || node.prev==null | node.next==null ) {
    } else {
        DListNode t1 = this.prev(node);
        DListNode t2;
        t2 = newNode(item, t1, node);
        t1.next = t2;
        node.prev = t2;
        ++size;
    }
  }

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    if ( node.next==null || node.prev==null || node==null ) {
    } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        node.item = null;
        --size;
    }
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }

  /** Test code
   */
  public static void main(String[] args) {
      DList t;
      t = new DList();
      TestInsert(t);
  }
  public static void TestInsert(DList l) {

      Integer i;
      System.out.println("### TESTING insertFront ###\nEmpty list is " + l);

      i = 9;
      l.insertFront(i);
      System.out.println("\nInserting 9 at front.\nList with 9 is " + l);
      if (l.head.next.item != (Integer) 9) {
          System.out.println("head.next.item is wrong.");
      }
      if (l.head.next.prev != l.head) {
          System.out.println("head.next.prev is wrong.");
      }
      if (l.head.prev.item != (Integer) 9) {
          System.out.println("head.prev.item is wrong.");
      }
      if (l.head.prev.next != l.head) {
          System.out.println("head.prev.next is wrong.");
      }
      if (l.size != 1) {
          System.out.println("size is wrong.");
      }

      i = 8;
      l.insertFront(i);
      System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);
      if (l.head.next.item != (Integer) 8) {
          System.out.println("head.next.item is wrong.");
      }
      if (l.head.next.prev != l.head) {
          System.out.println("head.next.prev is wrong.");
      }
      if (l.head.prev.item != (Integer) 9) {
          System.out.println("head.prev.item is wrong.");
      }
      if (l.head.prev.next != l.head) {
          System.out.println("head.prev.next is wrong.");
      }
      if (l.head.next.next != l.head.prev) {
          System.out.println("l.head.next.next != l.head.prev.");
      }
      if (l.head.prev.prev != l.head.next) {
          System.out.println("l.head.prev.prev != l.head.next.");
      }
      if (l.size != 2) {
          System.out.println("size is wrong.");
      }

      l.insertBack(10);
      l.insertBack(11);
      System.out.println("\nList with 10 and 11 is " + l);
      //l.insertBefore(l.prev(8),20);
      //l.insertBack(11);
      //System.out.println("\nList with 10 and 11 is " + l);
  }

}
