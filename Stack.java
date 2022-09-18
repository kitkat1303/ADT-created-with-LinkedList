/**
 *  The Stack class represents a stack list and inherits from the Quack class
 * @author katarinamcgaughy
 *
 */
public class Stack extends Quack {
	//top is the top of the stack
	private int top = 0;
	
	/**
	 * Stack 
	 * constructor 
	 */
	public Stack() {
		super();
	}
	
	/**
	 * push 
	 * this function adds an object to the top of the list
	 * @param next: the object you would like to insert
	 */
	public void push(Object next) {
		super.insert(next, top);
	}
	
	/**
	 * pop 
	 * this function removes and returns the last object added
	 * @return: the last object added
	 */
	public Object pop() {
		return super.remove(top); 
	}
	
	/**
	 * peek 
	 * this function returns the last object added without deleting it 
	 * @return: the last object added
	 */
	public Object peek() {
		return super.get(top); 
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
		Stack list1 = new Stack();
		
		System.out.println("Adding 0, 1, 2, 3, 4 to list: ");
		 for (int i = 0; i < 5; i++) {
			 list1.push(i);
		 }
		 
		 System.out.println("Should print (4 3 2 1 0): " + list1.toString());

		 System.out.println("Inserting -1");
		 list1.push(-1);
		 System.out.println("Should print (-1 4 3 2 1 0): " + list1.toString());
		 System.out.println();
		 
		 System.out.println("Removing object from list");
		 list1.pop();
		 System.out.println("Should print (4 3 2 1 0): " + list1.toString());
		 System.out.println();
		 
		 System.out.println("Peeking top item of stack: ");
		 System.out.println("Should print 4: " + list1.peek());
		 System.out.println();
		 
		 Stack list2 = new Stack();
		 System.out.println("Testing equals method: ");
		 System.out.println("This should return false: " + list2.equals(list1));	    
	}	
}
