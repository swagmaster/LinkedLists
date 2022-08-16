/*
 * Adam Atienza
 * 
 * Queue class is a child class of Quack which uses linked lists.
 * The queue class follows the linked list ADT and uses the super
 * methods accordingly.
 */
public class Queue extends Quack {
	
	/*
	 * default no-arg constructor.
	 */
	public Queue() {
		super();
	}

	/*
	 * insert() method overrides the parent insert method.
	 * and uses push() to follow Stack ADT.
	 */
	public void insert(Object next, int index) {
        enqueue(next);
    }

	/*
	 * remove() method overrides the parent insert method.
	 * and uses pop() to follow Stack ADT.
	 */
    public Object remove(int index) {
        return dequeue();
    }

    /*
     * enqueue() adds the object to the queue by using the 
     * insert method in the super class.
     */
	public void enqueue(Object next) {
		super.insert(next, super.size());
	}
	
	/*
     * dequeue() removes the object in queue by using the 
     * remove method in the super class.
     */
	public Object dequeue() {
		return super.remove(0);
	}
	
	/*
	 * Driver main method to test the class.
	 */
	public static void main(String[] args) {
		Queue line = new Queue();
		
		line.enqueue("Coke");
		line.enqueue("Pepsi");
		line.enqueue("Sprite");
		
		System.out.println("Printing queue: " + line);
		
		System.out.println("Dequeueing following FIFO: " + line.dequeue());
		System.out.println("Printing new queue: " + line.toString());
		
		Queue line2 = new Queue();
		line2.enqueue("Pepsi");
		line2.enqueue("Sprite");
		
		System.out.println("Printing new but same queue: " + line2);
		
		if(line.equals(line2)) 
			System.out.println("The queues are the same!");
		else 
			System.out.println("The queues are NOT the same!");
		
		line.dequeue();
		line.dequeue();
		System.out.println("Printing original queue (Should be empty): " + line);
		System.out.println("Attempting to dequeue an empty list: ");
		line.dequeue();
	}
	
}
