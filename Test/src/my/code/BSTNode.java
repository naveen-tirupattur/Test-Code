/**
 * Class for a BST Node
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class BSTNode {

	public int data;
	public BSTNode left, right;
	
	public BSTNode(int _data)
	{
		this.data = _data;
		this.left = null;
		this.right = null;	
		
	}	
	
	public static void add(BSTNode root, int data)
	{		
		if(data <= root.data)
		{
			if(root.left != null) add(root.left,data);
			else
				root.left = new BSTNode(data);
				
		}
		else
		{
			if(root.right != null) add(root.right,data);
			else
				root.right = new BSTNode(data);
		}
	}
	
	public static void inOrder(BSTNode root)
	{
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);		
	}
	
	public static BSTNode getParent()
	{
		return null;
	}
	
}
