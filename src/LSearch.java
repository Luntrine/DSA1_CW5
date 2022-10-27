public class LSearch {


	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/*
	 * Part 3: complete
	 */	
	/**
	 * This method searches through a Entry Linked List linearly (using a while loop) for an Entry 
	 * with the name equivalent to the one given in the method parameters. It then returns the 
	 * number of the Entry whose name matched the parameter.
	 * 
	 * @param name that the method is searching through the list for.
	 * @return the number of the Entry whose name matched the parameter.
	 */
	public int linearSearch(String name){
		Node currentNode = headNode;
		while(currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
			//returns number if search finds the number.
			if(currentNode.getValue().getName() == name) {
				return currentNode.getValue().getNumber();
			}
		}
		//returns -1 if reaches end of linked list.
		return -1;
	}
}
