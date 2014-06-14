/* LockDList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class LockDList extends DList {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

    public void lockNode(DListNode node) {
        ((LockDListNode) node).locked = true;
    }

  /**
   *  DList() constructor for an empty DList.
   */
  public LockDList() {
    //  Your solution here.
    head = newNode(0,null,null);
    head.next = head.prev = head;
    size = 0;
  }
  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }
  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    // Your solution here.
    if( !((LockDListNode)node).isLock() ) {
        super.remove(node);
    }
  }

  public static void main(String[] argv) {
	System.out.println("Testing Constructor");
	LockDList testList = new LockDList();
	System.out.println("Is empty? Should be true: " + testList.isEmpty());
	System.out.println("Should be zero length: " + testList.length());

	System.out.println("\nTesting insertFront");
	testList.insertFront(1);
	System.out.println("Is empty? Should be false: " + testList.isEmpty());
	System.out.println("Should be one length: " + testList.length());
	System.out.println("Should be [ 1 ]: " + testList);
	testList.insertFront(3);
	testList.insertFront(6);
	testList.insertFront(9);
	System.out.println(testList);
	testList.remove(testList.next(testList.front()));
	System.out.println(testList);

	LockDListNode currNode = (LockDListNode) ((DList) testList).front();
	currNode = (LockDListNode) testList.next(currNode);
	currNode = (LockDListNode) testList.next(currNode);
	testList.remove(currNode);
	System.out.println("After remove node" +testList);
	//testList.lockNode(currNode);
	testList.remove(currNode);

	System.out.println(testList);
  }
}
