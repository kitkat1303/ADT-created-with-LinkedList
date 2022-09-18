/**
 * The Queue class represents a queue list and inherits from the Quack class
 * @author katarinamcgaughy
 *
 */
public class Queue extends Quack {
	
	/**
	 * Queue 
	 * constructor 
	 */
	public Queue() {
		super();
	}
	
	/**
	 * enqueue
	 * this function adds an item to the end of the list 
	 * @param next: object to be added
	 */
	public void enqueue(Object next) {
		super.insert(next, size());
	}
	
	/**
	 * dequeue
	 * this function removes the first object from the list 
	 * @return: returns object removed 
	 */
	public Object dequeue() {
		return super.remove(0);
	}
	
	/**
	 * toString 
	 * @return: a string representation of the list
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * equals 
	 * @return: true if the lists compared are the exact same
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}
	
	/**
	 * Driver
	 */
	public static void main(String[] args) {
		Queue linkedList = new Queue();
		
		System.out.println("Adding 0, 1, 2, 3, 4: ");
		 for (int i = 0; i < 5; i++) {
			 linkedList.enqueue(i);
		 }
		 
		 System.out.println("Should print out 0 1 2 3 4: " + linkedList.toString());

		 System.out.println("Inserting 5");
		 linkedList.enqueue(5);
		 System.out.println("Should print out 0 1 2 3 4 5: " + linkedList.toString());
		 System.out.println();
		 
		 System.out.println("Removing object from list");
		 linkedList.dequeue();
		 System.out.println("Should print out 1 2 3 4 5: " + linkedList.toString());
		 System.out.println();
		 
		 Queue list2 = new Queue();
		 System.out.println("Testing equals method: ");
		 System.out.println("This should return false: " + list2.equals(linkedList));
	   
	}
}
