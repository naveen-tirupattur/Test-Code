/**
 * Main class to call all other example classes
 */
package my.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;





/**
 * @author Naveen
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] a = {5,6,7,0,1,2,4};	
		//BSTNode root = BSTProblems.convertArrayToBST(a, 0, a.length-1);*/		
		//System.out.println("Index: "+ArrayManipulations.findElementInRotatedArray(a, 0, a.length-1, 1));
		Object a = "s";
		Object b = "q";
		swap(a,b);
		System.out.println(a);
		System.out.println(b);
		
	}

	public static int rand7()
	{
		int val=0;
		do
		{
			val = 5*(rand5() - 1) + rand5();
		}while(val > 21);

		
		return val%7+1;
	}

	public static int rand5()
	{
		return 1;
	}
	
	public static void swap(Object a, Object b)
	{
		Object temp = a;
		a = b;
		b = temp;		
	}

}
