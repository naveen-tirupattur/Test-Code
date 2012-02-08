/**
 * Class for Binary Search Tree problems
 */
package my.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Naveen
 *
 */
public class BSTProblems {

	public static BSTNode convertToList(BSTNode root)	
	{
		if(root == null) return null;

		//Get the Left List and Right List
		BSTNode leftList = convertToList(root.left);
		BSTNode rightList = convertToList(root.right);

		//Make the node as circular linked list
		root.left = root;
		root.right = root;

		//append the left list and right list to a single list

		leftList = append(leftList,root);
		leftList = append(leftList,rightList);

		return leftList;

	}

	public static BSTNode append(BSTNode a, BSTNode b)
	{
		if(a == null) return b;

		if(b == null)return a;

		BSTNode aLast = a.left;

		BSTNode bLast = b.left;

		join(aLast,b);
		join(bLast, a);

		return a;

	}

	public static void join(BSTNode a, BSTNode b) {

		a.right = b;
		b.left = a;

	}

	public static void printList(BSTNode head) {
		BSTNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.right;
			if (current == head) break;
		}

		System.out.println();
	}

	public static BSTNode convertArrayToBST(int[] a, int start, int end)
	{
		if(start > end) return null;

		int mid = (start+end)/2;

		BSTNode root = new BSTNode(a[mid]);

		root.left = convertArrayToBST(a, start, mid -1);

		root.right = convertArrayToBST(a, mid+1, end);

		return root;
	}

	public static int getHeight(BSTNode root)
	{
		if(root == null) return 0;

		return 1+Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static boolean isBalanced(BSTNode root)
	{
		if(root == null) return true;
		int difference = Math.abs(getHeight(root.left) - getHeight(root.right));
		return(isBalanced(root.left) && isBalanced(root.right) &&  difference <=1);

	}

	public static List<LinkedList<BSTNode>> getLists(BSTNode root)
	{
		int level = 0;

		//List of LinkedLists..Stores linked lists for each level
		List<LinkedList<BSTNode>> resultList = new ArrayList<LinkedList<BSTNode>>();

		//Store all the nodes at a level in linked list
		LinkedList<BSTNode> list = new LinkedList<BSTNode>();

		//Add the root node
		list.add(root);

		//Add it to final list
		resultList.add(level,list);

		while(true)
		{
			list = new LinkedList<BSTNode>();

			//For each level get all nodes and get their children
			for(int i=0;i<resultList.get(level).size();i++)
			{
				//get the child at that level
				BSTNode n = resultList.get(level).get(i);

				//Add the children together into one list
				if(n != null)
				{
					if(n.left!=null) list.add(n.left);
					if(n.right!=null) list.add(n.right);
				}
			}
			//If there are nodes at that level update the result list else break
			if(list.size() > 0) resultList.add(level+1,list);
			else
				break;	

			//update the level
			level++;
		}

		return resultList;
	}

	public static BSTNode findSuccessor(BSTNode node)
	{
		if(node == null) return null;

		if(node.right != null)
		{
			BSTNode rightNode = node.right;
			while(rightNode.left != null)
			{
				rightNode = rightNode.left;
			}
			return rightNode;
		}
		else
		{
			BSTNode e = node.getParent();
			while(e != null)
			{
				if(e.left == node) break;
				node = e;
				e = e.getParent();				
			}
			return e;
		}		
	}

	public static BSTNode findCommonAncestor(BSTNode root, int p, int q)
	{

		if(root == null) return null;

		if(covers(root.left,p) && covers(root.left,q)) return findCommonAncestor(root.left,p,q);

		if(covers(root.right,p) && covers(root.right,q)) return findCommonAncestor(root.right,p,q);

		return root;
	}

	public static boolean covers(BSTNode node, int p)
	{

		if(node == null) return false;

		if(node.data == p) return true;

		return(covers(node.left,p) || covers(node.right,p));

	}

	//Check if tree with root2 is sub tree of tree with root 1
	public static boolean isSubTree(BSTNode root1, BSTNode root2)
	{

		if(root2 == null) return true;

		if(root1 == null) return false;

		if(isIdentical(root1,root2)) return true;

		return(isSubTree(root1.left,root2) || isSubTree(root1.right, root2));
	}

	public static boolean isIdentical(BSTNode root1, BSTNode root2)
	{

		if(root1 == null && root2 == null) return true;

		if(root1 == null || root2 == null) return false;

		return(root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right,root2.right));
	}

	public static void findPath(BSTNode root, int sum, ArrayList<Integer> buffer, int level)
	{
		if(root == null) return;

		int temp = sum;
		buffer.add(root.data);
		for(int i = level;i>-1;i--)
		{
			temp -= buffer.get(i).intValue();

			if(temp == 0) printPaths(buffer,level,i);
		}

		ArrayList<Integer> buffer1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> buffer2 = (ArrayList<Integer>) buffer.clone();

		findPath(root.left,sum,buffer1,level+1);
		findPath(root.right,sum,buffer2,level+1);

	}

	public static void printPaths(ArrayList<Integer> buffer, int start, int end)
	{
		System.out.println("Path: ");
		for(int i=end;i<=start;i++)
		{
			System.out.println(buffer.get(i));
		}

	}

	public static boolean isBST(BSTNode root)
	{
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBSTHelper(BSTNode node, int low, int max)
	{
		if(node == null) return true;

		if(node.data >= low && node.data < max)
		{
			return(isBSTHelper(node.left, low, node.data) && isBSTHelper(node.right,node.data,max));
		}

		return false;
	}

	public static boolean isBST(BSTNode node, int prev)	

	{
		if(node == null) return true;

		if(isBST(node.left,prev))
		{
			if(node.data >= prev)
			{
				prev = node.data;
				return isBST(node.right,prev);
			}else
				return false;

		}else
			return false;
	}

	public static BSTNode createTree(List<Integer> inOrder, List<Integer> preOrder)
	{
		BSTNode node = null;
		int prePos, inPos;
		List<Integer> leftPreOrder, rightPreOrder, leftInOrder, rightInOrder;

		if(inOrder.size() !=0 && preOrder.size() !=0)
		{
			node = new BSTNode(preOrder.get(0).intValue());

			inPos = inOrder.indexOf(node.data);

			leftInOrder = inOrder.subList(0, inPos);
			rightInOrder = inOrder.subList(inPos+1, inOrder.size());

			prePos = leftInOrder.size();

			leftPreOrder = preOrder.subList(1, prePos+1);

			rightPreOrder = preOrder.subList(prePos+1, preOrder.size());

			node.left = createTree(leftInOrder, leftPreOrder);

			node.right = createTree(rightInOrder, rightPreOrder);

		}
		return node;
	}

	public static BSTNode commonAncestor(BSTNode root, int p, int q)
	{
		if(root == null) return null;

		//If given node is one of p or q
		if(root.data == p || root.data == q) return root;
		
		//Check if either p or q are on left side
		BSTNode left = commonAncestor(root.left, p, q);
		
		//Check if either p or q are on right side
		BSTNode right = commonAncestor(root.right, p, q);
		
		//If both left and right are not null i.e both left and right node have one of p or q then root is common ancestor
		if(left != null && right != null) return root;
		
		//If one of side is null then other side has both p and q return the side which is not null
		return left != null ? left : right;
		
	}
	
	//Function to get common ancestor in a BST
	public static BSTNode commonAncestorBSTTree(BSTNode root, int p, int q)
	{
		if (root == null) return null;
		
		if(root.data > p && root.data > q) return commonAncestorBSTTree(root.left, p, q);
		
		if(root.data < p && root.data < q) return commonAncestorBSTTree(root.right, p, q);
		
		return root;
	}
}


