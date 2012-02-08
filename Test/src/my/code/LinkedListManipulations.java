/**
 * Class for Linked List problems
 */
package my.code;

import java.util.Stack;

/**
 * @author Naveen
 *
 */
public class LinkedListManipulations {

	//remove duplicates
	public static Node removeDuplicatesWithBuffer(Node head)
	{
		Node prev = head, current = head.next;
		boolean used[] = new boolean[128];
		used[head.data]=true;
		while(current.next != null)		
		{
			if(used[current.data]){
				prev.next = current.next;	
				current = current.next;
				current.next = null;				
			}else
			{
				used[current.data] = true;
				current = current.next;
			}
			prev = prev.next;
		}

		return head;


	}

	//find nth last element

	public static Node findNFromLast(Node head,int n)
	{
		Node firstR = head,secondR = head;

		for(int i=0;i<n;i++)
		{
			firstR= firstR.next;
		}

		while(firstR.next != null)
		{
			firstR = firstR.next;
			secondR = secondR.next;
		}

		return secondR;
	}

	//Delete Middle Node
	public static boolean deleteMiddleNode(Node node)
	{

		if(node == null) return false;

		if(node.next == null) node = null;

		node.data = node.next.data;

		node.next = node.next.next;

		return true;

	}

	//Add two nodes
	public static Node addNodes(int carry,Node n1, Node n2)
	{

		if(n1== null && n2 == null) return null;

		int value=carry;		

		if(n1!=null) value += n1.data;

		if(n2!=null) value += n2.data;

		Node n = new Node(value%10);

		Node newNode = addNodes(value > 10 ? 1:0, n1.next == null ? null:n1.next, n2.next == null ? null:n2.next);

		n.next = newNode;

		return n;

	}

	// find beginning of Cycle

	public static Node findBeginning(Node head)
	{

		Node fast = head, slow = head;

		if(head == null) return null;

		while(fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;

			if(fast == slow) break;
		}

		if(fast.next == null) return null;

		slow = head;
		while(fast != slow)
		{

			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}

	//Sort a stack
	public static Stack<Integer> sort(Stack<Integer> s)
	{

		Stack<Integer> r = new Stack<Integer>();

		if(s == null || s.isEmpty()) return null;

		while(!s.isEmpty())
		{

			int tmp = (Integer) s.pop();

			while(!r.isEmpty() && (Integer)r.peek() < Integer.valueOf(tmp))
			{
				s.push(r.pop());
			}

			r.push(Integer.valueOf(tmp));

		}
		return r;

	}


}
