
/*
 * Adam Atienza
 * 
 * Quack class uses the linked list method to insert and remove
 * objects from a list of unknown size.
 */
public class Quack {

	private Node head = null;
	
	/*
	 * Node class takes in the data of the object and 
	 * has pointer to the 'next' Node.
	 */
	private class Node {
        public Object data; 
        public Node next; 

        /*
         * Node constructor takes in the object data and the pointer
         * and intializes it accordngly.
         */
        private Node(Object obj, Node next){
            data = obj;
            this.next = next;
        }
    }

	/*
	 * insert() takes in the object data and the index it is being 
	 * inserted at. The method checks several conditions before adjusting 
	 * the linked list according to the insert.
	 */
	protected void insert(Object newData , int index) {
		
		if(index != 0 && isEmpty()) {
			System.out.println("Empty list.");
		}
		else if(head == null) {
			head = new Node(newData, head);
			return;
		}
		else if(index > 1 && size() == 1) {
			System.out.println("List has a single element. Add to the first index.");
		}
		else if(index == 0 && size() == 1) {
			Node otherHead = head;
			head = new Node(newData, otherHead); //if the linked list is of size 1, set head to a new one, and the old head to the next one.
			return;
		}
		else if(index == 1 && size() == 1) {
			head.next = new Node(newData, null);
			return;
		}
		else if(index > size()) {
			System.out.println("Invalid index.");
		}
		else if(index == 0) {
			Node otherHead = head;
			head = new Node(newData, otherHead);
			return;
		}
		else {
			Node updatedNode = moveNode(index); //adjusting the pointers
			Node movedNode = updatedNode.next;
			updatedNode.next = new Node (newData, movedNode);
		}
	}
	
	/*
	 * remove() goes to the index of the linked list and
	 * removes that object. The method checks several conditions
	 * before doing so
	 */
	protected Object remove(int index) {
		Object obj; //create container to store the object in
		if(isEmpty()) {
			System.out.println("Cannot remove from an empty list.");
			return null;
		}
		else if(index > 0 && size() == 1) {
			System.out.println("Invalid index.");
			return null;
		}
		else if(index == 0 && size() == 1) {
			obj = head.data; 
			head = null;
			return obj;
		}
		else if(index == 0) {
			obj = head.data;
			head = head.next;
			return obj;
		}
		else {
			if(index > size()) {
				System.out.println("Invalid index.");
			}
			Node updateNode = moveNode(index);//adjusting the pointers of the nodes.
			Node n = updateNode.next;
			updateNode.next = n.next;
			n.next = null;
			return n;
		}
	}
	
	/*
	 * moveNode() updates the Node by changing the pointer 
	 * and returning it.
	 */
	private Node moveNode(int i) {
		Node n = head;
        for(int j = 1; j < i; j++)
            n = n.next;
        return n;
	}
	
	/*
	 * append() takes in a new Object data and adds it the 
	 * end of the linked list.
	 */
	protected void append(Object newData) {
		insert(newData, size());
		return;
	}
	
	/*
	 * delete() removes the Object data from the given index.
	 */
	protected void delete(int index) {
		remove(index);
		return;
	}
	
	/*
	 * get() just returns the Object data at the given index..
	 */
	protected Object get(int index) {
		if(index > size()) {
			System.out.println("Invalid index.");
			return null;
		} 
		else {
			return head.data;
		}
	}
	
	/*
	 * size() gets the number of data there is in the linked list.
	 */
	public int size() {
		if(head == null) {
			return 0;
		}
		
		int counter = 1;
		Node current = head;
		//traverses the linked list and counts the iterations
		while(current.next != null) {
			current= current.next;
			counter++;
		}
		return counter;
	}
	
	/*
	 * toString() puts the linked list in String output form.
	 */
	public String toString() {
		String retVal = "";
		Node node = head;
		for(int i = 0; i < size(); i++) {
			retVal += node.data + ", ";
			node = node.next;
		}
		return retVal;
	}
	
	/*
	 * isEmpty() checks to see if the linked list is empty.
	 */
	public boolean isEmpty() {
		/*
		if(size() == 0) {
			return true;
		} else {
			return false;
		}*/
		return this.head == null;
	}
	
	/*
	 * indexOf() takes in a target Object and checks to see if 
	 * it exists and if so, at what index.
	 */
	protected int indexOf(Object target) {
		Node node = head;
		for(int i = 0; i < size(); i++) {
			if(head.data == null) {
				return -1;
			}
			if(node.data.equals(target)) {
				return i;
			}
			else if(node.next == null) {
				return -1;
			}
			else {
				node = node.next;
			}
		}
		return -1;
	}
	
	/*
	 * equals() method checks to see if another instance of Quack
	 * exists.
	 */
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		}
		else if(getClass() != other.getClass()) {
			return false;
		}
		else {
			Quack real = (Quack) other;
			if(size() != real.size()) {
				return false;
			}
			Node position = head;
			Node otherPosition = real.head;
			while(position != null) {
				if(!(position.data.equals(otherPosition.data))) {
					return false;
				}
				position = position.next;
				otherPosition = otherPosition.next;
			}
			return true;
		}
	}
	
	/*
	 * Driver main method to test the class.
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

	    System.out.println("Attempting an illicit insert at index 5. Error message should print: ");
	    one.insert(400, 5);
	    System.out.println("One (on insert) (should still be empty): " + one);
	    
	}
	
}
