/**
 * Class for a Node in Linked List
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class Node {

	Node next = null;
	int data;
	public Node(int d) { data = d; }
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}
	
	void appendToTail(Node n1) {
		Node n = this;
		while (n.next != null) { n = n.next; }
		n.next = n1;
	}

	public void printNodes()
	{
		Node n = this;
		do
		{
			System.out.println(n.data);
			n = n.next;
		}while(n.next!=null);
	}


}
