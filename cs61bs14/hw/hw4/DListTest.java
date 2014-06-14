/*
 * File   : DListTest.java
 * Author : DM
 * License: BSD 3-clause license http://gotfu.wordpress.com/bsd-3-clause-license/
 * Copyright (c) 2012 Got-fu? http://gotfu.wordpress.com/
 *
 * Doubly-linked lists and Inheritance.
 *
 * This tests the validity of the DList class.
 */

import list.DListNode;
import list.DList;

public class DListTest {

	public static void main(String[] args) {
		int score = 24;

		System.out.println("Creating a DList, list");
		DList list = new DList();
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 0
						|| !list.toString().equals("[  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'first' at the front:");
		list.insertFront("first");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 1
						|| !list.toString().equals("[  first  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'second' at the front:");
		list.insertFront("second");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 2
						|| !list.toString().equals("[  second  first  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'third' at the front:");
		list.insertFront("third");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 3
						|| !list.toString().equals("[  third  second  first  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'fourth' at the back:");
		list.insertBack("fourth");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 4
						|| !list.toString().equals("[  third  second  first  fourth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'fifth' at the back:");
		list.insertBack("fifth");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 5
						|| !list.toString().equals("[  third  second  first  fourth  fifth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Inserting 'sixth' at the back:");
		list.insertBack("sixth");
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 6
						|| !list.toString().equals("[  third  second  first  fourth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nGetting the node at the front.");
		DListNode node = list.front();
		System.out.println("->" + node.item);
		if (!node.item.equals("third")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Moving forward using next().");
		node = list.next(node);
		System.out.println("->" + node.item);
		if (!node.item.equals("second")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Moving forward using next().");
		node = list.next(node);
		System.out.println("->" + node.item);
		if (!node.item.equals("first")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nInserting 'seventh' after the current node:");
		list.insertAfter("seventh", node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 7
						|| !list.toString().equals("[  third  second  first  seventh  fourth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nGetting the node at the back.");
		node = list.back();
		System.out.println("->" + node.item);
		if (!node.item.equals("sixth")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Moving back using prev().");
		node = list.prev(node);
		System.out.println("->" + node.item);
		if (!node.item.equals("fifth")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("Moving back using prev().");
		node = list.prev(node);
		System.out.println("->" + node.item);
		if (!node.item.equals("fourth")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nInserting 'eighth' before the current node:");
		list.insertBefore("eighth", node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 8
						|| !list.toString().equals("[  third  second  first  seventh  eighth  fourth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nRemoving the current node.");
		list.remove(node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 7
						|| !list.toString().equals("[  third  second  first  seventh  eighth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nTrying to remove the already removed node, again. (nothing should happen)");
		list.remove(node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 7
						|| !list.toString().equals("[  third  second  first  seventh  eighth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nTrying to move forward using the removed node as refence. (should return null)");
		DListNode thisShouldBeNull = list.next(node);
		if (thisShouldBeNull != null) {
			System.out.println("BAD RESULT!");
			score--;
		} else {
			System.out.println("Good!");
		}

		System.out.println("\nTry Inserting something after the already deleted node. (nothing should happen)");
		list.insertAfter("BadMojo!", node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 7
						|| !list.toString().equals("[  third  second  first  seventh  eighth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		//make a second list
		System.out.println("\n---\n\nCreate a second DList, list2 and add: list2item1, list2item2, list2item3, list2item4");
		DList list2 = new DList();
		list2.insertBack("list2item1");
		list2.insertBack("list2item2");
		list2.insertBack("list2item3");
		list2.insertBack("list2item4");
		System.out.println("list2.length(): " + list2.length() + "  list2.tostring():" + list2);
		if (list2.length() != 4
						|| !list2.toString().equals("[  list2item1  list2item2  list2item3  list2item4  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}

		System.out.println("\nGetting the node at the front of list2.");
		node = list2.front();
		System.out.println("->" + node.item);
		if (!node.item.equals("list2item1")) {
			System.out.println("BAD RESULT!");
			score--;
		}

		//try using the node from list2 to insert in list 1.
		System.out.println("\nTrying to insert something into the first list using a node form the second list as a reference:");
		list.insertAfter("BadMojo!", node);
		System.out.println("list.length(): " + list.length() + "  list.tostring():" + list);
		if (list.length() != 7
						|| !list.toString().equals("[  third  second  first  seventh  eighth  fifth  sixth  ]")
						) {
			System.out.println("BAD RESULT!");
			score--;
		}
		System.out.println("list2.length(): " + list2.length() + "  list2.tostring():" + list2);
		if (list2.length() != 4
						|| !list2.toString().equals("[  list2item1  list2item2  list2item3  list2item4  ]"))

		System.out.println("\nTrying to move forward in first list using a node from the second list as a refence. (should return null)");
		DListNode thisShouldBeNullAlso = list.next(node);
		if (thisShouldBeNullAlso != null) {
			System.out.println("BAD RESULT!");
			score--;
		} else {
			System.out.println("Good!");
		}

		System.out.println("\nSuccessful tests: " + score + "/24");
		System.out.println(
						"If you scored 21/24 (failed the last three tests) you are within the parameters given in hw4\n"
						+ "To get a 24/24 score you need to make a subclass of DListNode aware of the list it belongs to\n"
						+ "and a subclass of DList that overrides just enough methods to leverage that.");
	}
}
