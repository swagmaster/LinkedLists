/*
 * Adam Atienza
 * 
 * Stack class is a child class of Quack which uses linked lists.
 * The stack class follows the linked list ADT and uses the super
 * methods accordingly.
 */
public class Stack extends Quack {

	/*
	 * default no-arg constructor.
	 */
	public Stack() {
		super();
	}
	
	/*
	 * insert() method overrides the parent insert method.
	 * and uses push() to follow Stack ADT.
	 */
	public void insert(Object next, int index) {
        push(next);
    }

	/*
	 * remove() method overrides the parent insert method.
	 * and uses pop() to follow Stack ADT.
	 */
    public Object remove(int index) {
        return pop();
    }
	
    /*
     * push() adds the object to the stack by using the 
     * insert method in the super class.
     */
	public void push(Object next) {
		super.insert(next, 0);
	}
	
	/*
	 * pop() removes the object from the top of the stack
	 * by using the remove method in the super class.
	 */
	public Object pop() {
		return super.remove(0);
	}
	
	/*
	 * peek() gets the object data from the top of the stack.
	 * Uses get() method from super class.
	 */
	public Object peek() {
		return super.get(0);
	}
	
	/*
	 * Driver main method to test the class.
	 */
	public static void main(String[] args) {
		Stack teams = new Stack();
		
		teams.push("Warriors");
		teams.push("Suns");
		teams.push("Celtics");
		
		System.out.println("The stack is: " + teams);
		
		teams.pop();
		System.out.println("Popping Celtics: " + teams);
		
		teams.pop();
		System.out.println("Popping Suns: " + teams);
		
		teams.pop();
		System.out.println("Popping Warriors: " + teams);
	
		System.out.println("Attempting to pop() an empty stack: ");
		teams.pop();// Should print that cannot remove from an empty list.
	}
}
