/**
 * The quack class is a base class that is used to create a
 * Queue class and a Stack class based on a link list
 * @author katarinamcgaughy
 *
 */
public class Quack {
	private Node head;

	/*
	 * Quack 
	 * constructor that sets head to null
	 */
	public Quack() {
		head = null;
	}

	/**
	 * Node 
	 * this class represents the node of the list
	 */
	public class Node {
		//item is the data held in node
		private Object item;
		//next is the link to the next node 
		private Node next;

		/**
		 * Node 
		 * Constructor that sets item and next to null
		 */
		public Node() {
			this.item = null;
			this.next = null;
		}

		/**
		 * Node 
		 * Constructor that sets item and next to nextItem and linkValue
		 * @param: newItem is the data and linkValue is the next node
		 */
		public Node(Object newItem, Node linkValue) {
			this.item = newItem;
			this.next = linkValue;
		}	
	}
	
	public void insert(Object newData, int index) {
		if (index < 0) {
			System.out.println("Index cannot be negative.");
		}
		else if (index == 0) {
			head = new Node(newData, head);
		}
		else {
			Node current = head;
			int count = 1;
			// Find the right location to insert
			while (current != null && count < index) {
				count++;
				current=current.next;
			}
			// Check for invalid cases:
			if (count == index) {
				current.next = new Node(newData, current.next);
			}else {
				System.out.println("Index not found.");
			}
		}
	}
	
	/**
	 * remove 
	 * this function takes in an index and removes the object at that index
	 * @param index: must be greater than or equal to 0 and less than
	 * or equal to size
	 * @return: returns the object removed
	 */
	protected Object remove(int index) {
		Node current = head;
		if (index < 0) {
			System.out.println("Index cannot be negative.");
		}
		else if (index == 0) {
			if (head==null) {
				System.out.println("List is empty, can't remove item.");
			}
			else {
			head = head.next;
			return current;
			}
		} else {
			int count = 0;
			Node previous = null;
			while (current != null && count <= index) {
				count++;
				previous=current;
				current=current.next;
			}
			if (count == index) {
				previous.next = current.next;
				return current;
			}
			else {
				System.out.println("Index out of bounds.");
			}
		}
		return null;
	}

	/**
	 * append 
	 * this function adds an item to the end of the list
	 * @param newData: item to be added
	 */
	protected void append(Object newData) {
		insert(newData, size());
	}

	/**
	 * delete 
	 * removes an item from the list without returning it
	 * 
	 * @param index: index of item that will be removed
	 */
	protected void delete(int index) {
		remove(index);
	}

	/**
	 * get 
	 * returns the object at the specified index
	 * 
	 * @param index: index of object to be returned
	 * @return: object returned given the index
	 */
	protected Object get(int index) {
		int count = 0;
		Node current = head;
		if (index >= size()) {
			System.out.println("Index must be smaller " + "than the number of elements.");
		} else {
			while (current != null) {
				if (count == index)
					return current.item;
				count++;
				current = current.next;
			}
		}
		return null;
	}

	/**
	 * size
	 * @return: Returns the size of linked list by traversing the list
	 */ 
	public int size() {
		int count = 0;
		Node position = this.head;
		while (position != null) {
			count++;
			position = position.next;
		}
		return count;
	}

	/**
	 * toString()
	 * @return: returns the string representation of the list in natural order
	 * 
	 * 
	 * the string returned should be the list in natural order, starting with the
	 *  top (head), with NO space between each item.
	 * 
	 */
	
	public String toString() {
		Node currentPosition = this.head;
		String s = new String("");
		while (currentPosition != null) {
			if (s.equals(""))
				s = "" + currentPosition.item; // so no space before first element
			else
				s = s + " " + currentPosition.item;
			currentPosition = currentPosition.next;
		}
		return s;
	}

	/**
	 * isEmpty 
	 * @return: true if the list is empty
	 */
	public boolean isEmpty() {
		return (this.head == null);
	}

	/**
	 * indexOf this functions searches through the list and returns the index where
	 * the target object is found
	 * 
	 * @param target: object to search for
	 * @return: returns the index where the object was found if it was not found it
	 *          returns -1
	 */
	protected int indexOf(Object target) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.item.equals(target)) {
				return count;
			}
			count++;
			current = current.next;
		}
		return -1;
	}

	/**
	 * equals 
	 * @return: true if the lists compared are the exact same
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if (!(otherObject instanceof Quack))
			return false;
		else {
			Quack otherList = (Quack) otherObject;
			Node thisPosition = this.head;
			Node otherPosition = otherList.head;
			while (thisPosition != null && otherPosition != null) {
				if (!otherPosition.item.equals(thisPosition.item)) {
					return false;
				} else {
					thisPosition = thisPosition.next;
					otherPosition = otherPosition.next;
				}
			}
			if (thisPosition == null && otherPosition == null) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Driver
	 */
	public static void main(String[] args) {
		    Quack empty = new Quack();
		    Quack one = new Quack();
		    Quack multiple = new Quack();
			
		    one.append(5);
		    multiple.append(10);
		    multiple.append(20);
		    multiple.append(30);

		    System.out.println("Empty (should print nothing): " + empty);     // ( note the implicit call to toString()! )
		    System.out.println("One (should print '5'): " + one);
		    System.out.println("Multiple (should print '10, 20, 30'): " + multiple);	

		    one.delete(0);
		    multiple.delete(1);
		    System.out.println("One (upon delete) (should be empty): " + one);
		    System.out.println("Multiple (upon delete) (should be '10, 30'): " + multiple);
		    System.out.println("One (upon delete) (should be empty): and should print error message: ");
		    one.delete(0);
		    

		    System.out.println("Attempting an illicit insert at index 5. Error message should print: ");
		    one.insert(400, 5);
		    System.out.println("One (on insert) (should still be empty): " + one);
		    
		    one.insert(2, 0);
		    one.insert(1, 0);
		    one.insert(3, 2);
		    System.out.println("Should print: 1 2 3: " + one.toString());
		    System.out.println("Should print false: " + one.isEmpty()); 
		    System.out.println("Should print 3: " + one.size()); 
		    System.out.println("Should print 1: " + one.get(0)); 
		    System.out.println("Should print 3: " + one.indexOf(2)); 
		    one.remove(0);
		    System.out.println("Should print: 2 3: " + one.toString());
		    System.out.println("Should print 2: " + one.size()); 
		    System.out.println("Attempting to remove an invalid index: ");
		    one.remove(3); 
		    one.remove(0);
		    System.out.println("Should print 3: " + one.toString());
		    one.remove(0);
		    System.out.println("Should print nothing: " + one.toString());
		    one.remove(0);
   
		}
}
