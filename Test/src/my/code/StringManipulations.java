/**
 * Class for String Manipulations
 * 
 */  
package my.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Naveen
 *
 */
public class StringManipulations {

	//Remove Duplicate Characters without Additional memory
	public static String removeDuplicates(char[] c)
	{
		int src=0, dst=0,i;
		while(src < c.length)
		{
			for(i=0;i<src;i++)
			{
				if(c[i] == c[src]) break;
			}

			if(i==src)
			{
				c[dst++] = c[src];
			}				
			src++;
		}
		return new String(c,0,dst);
	}

	//Remove Duplicate Characters with Additional memory
	public static String removeDuplicates1(char[] c)
	{

		int src=0, dst = 0;

		boolean[] used = new boolean[128];

		while(src < c.length)
		{

			if(!used[c[src]])
			{

				c[dst++] = c[src];
				used[c[src]] = true;
			}
			src++;
		}

		return new String(c,0,dst);
	}
	//Generate all combinations of string
	public static void doCombine(char[] in, StringBuffer out, int length, int start)
	{
		for(int i=start;i<length;i++)
		{
			out.append(in[i]);			
			System.out.println(out);
			doCombine(in,out,length,i+1);
			out.setLength(out.length() - 1);
		}

	}

	public static void printCombinations(String prefix, String suffix)
	{
		System.out.println(prefix);
		for(int i=0;i<suffix.length();i++)
		{
			printCombinations(prefix+suffix.charAt(i), suffix.substring(i+1));
		}
	}

	public static int longestSubString(char[] str)
	{
		int max_length = 1;
		int cur_length = 1;
		int[] visited = new int[256];

		for(int i=0;i<256;i++) visited[i] = -1;

		visited[str[0]] = 0;
		for(int i=1;i<str.length;i++)
		{		
			int prev_index = visited[str[i]];

			if(prev_index == -1 || prev_index < i - cur_length)
			{
				cur_length++;
			}
			else
			{
				if(cur_length > max_length) max_length = cur_length;
				cur_length = i - prev_index;
			}
			visited[str[i]] = i;

		}
		if(cur_length > max_length) max_length = cur_length;

		return max_length;


	}

	//Test if two Strings are Anagrams are not

	public static boolean isAnagram(char[] s, char[] p)
	{

		if(s.length != p.length) return false;

		int[] count = new int[128];
		int uniqueCount = 0;

		for(int i=0;i<s.length;i++)
		{		 
			if(count[s[i]] == 0)
			{				
				uniqueCount++;
			}
			count[s[i]]++;

		}
		for(int i=0;i<p.length;i++)
		{
			if(count[p[i]] == 0) return false;

			--count[p[i]];

			if(count[p[i]] == 0)
			{
				uniqueCount--;
			}

		}

		if(uniqueCount !=0) return false;

		return true;
	}

	public static boolean isPalindrome(String s)
	{
		int n = s.length();
		int l =0,r=n-1;

		if(n == 0 || n == 1) return true;
		while(l <= r)
		{

			if(s.charAt(l) != s.charAt(r)) return false;
			else
			{
				l++;
				r--;
			}			
		}
		return true;

	}

	public static String expandAroundCenter(String s, int c) {

		boolean flag = false;
		int l = c-1, r = c+1;

		int n = s.length();

		if(c == 0) return s.substring(0,1);

		if(c == n-1) return s.substring(n-1);

		while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
			flag = true;
		}
		if(flag)
		{			 
			l = l+1;
			r = r-1;
			if(r == n-1)
				return s.substring(l);
			else
				return s.substring(l,r);
		}
		else return s.substring(c,c+1);
	}

	public static String longestPalindromeSimple(String s) {
		int n = s.length();
		if (n == 0) return "";
		String longest = s.substring(0, 1);  // a single char itself is a palindrome
		for (int i = 0; i < n-1; i++) {
			String p1 = expandAroundCenter(s, i);
			if (p1.length() > longest.length())
				longest = p1;			
		}
		return longest;
	}

	public static String reverseRecursively(String str)
	{
		if(str.length() < 2) return str;

		return reverseRecursively(str.substring(1))+ str.charAt(0);
	}

	//Generate all subsets
	public static List<List<String>> getSubsets(List<String> s, int index)
	{
		//Create a List of Lists to store all subsets
		List<List<String>> allSubsets = new ArrayList<List<String>>();

		//If you reach the count of all possible subsets
		if(index == s.size())
		{
			//Create an empty subset and add it to list of all subsets
			List<String> emptySubset = new ArrayList<String>();
			allSubsets.add(emptySubset);

		}else
		{
			//Get one element from initial list
			String element = s.get(index);

			//get the existing subsets
			allSubsets = getSubsets(s, index+1);

			//Create a list of lists to store more subsets
			List<List<String>> moreSubsets = new ArrayList<List<String>>();

			//For each of existing subset
			for(List<String> subsets:allSubsets)
			{
				List<String> tempSubSet = new ArrayList<String>();

				tempSubSet.addAll(subsets);
				tempSubSet.add(element);

				Collections.sort(tempSubSet);

				moreSubsets.add(tempSubSet);
			}

			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

	public static boolean paintFill(char[][] matrix, int x, int y, char newChar, char oldChar)
	{

		if( x < 0 || y < 0 || x > matrix.length || y > matrix[0].length) return false;

		if(matrix[x][y] == oldChar)
		{

			matrix[x][y] = newChar;
			paintFill(matrix,x-1,y,newChar,oldChar);
			paintFill(matrix,x+1,y,newChar,oldChar);
			paintFill(matrix,x,y-1,newChar,oldChar);
			paintFill(matrix,x,y+1,newChar,oldChar);
		}

		return true;
	}


	//Print all ways of calculating change for n cents
	public static Set<String> printWays(StringBuffer out, int n)
	{
		Set<String> combinations = new HashSet<String>();

		if(n < 0) return combinations;

		//If you have no more cents, print the combinations
		if(n == 0)
		{
			//System.out.println(out);
			combinations.add(new String(out));
		}
		else
		{			
			
				if(n - 25 >= 0)
				{
					out.append('Q');				
					combinations.addAll(printWays(out,n-25));
					out.setLength(out.length() - 1);
				}

				if(n - 10 >= 0)
				{
					out.append('D');
					combinations.addAll(printWays(out,n-10));
					out.setLength(out.length() - 1);
				}
				
				if(n - 5 >= 0)
				{
					out.append('N');							
					combinations.addAll(printWays(out,n-5));
					out.setLength(out.length() - 1);				
				}
				
				if(n - 1 >= 0)
				{				
					out.append('C');
					combinations.addAll(printWays(out,n-1));
					out.setLength(out.length() - 1);
				}
			}		

			return combinations;
		}



		//Print all parantheses
		public static void printParantheses(int l, int r, StringBuffer out)
		{			
			//If no more parantheses print the output 
			if( l == 0 && r == 0) System.out.println(out);
			else
			{
				//If you have left parantheses
				if( l > 0)
				{
					out.append("(");
					printParantheses(l-1, r, out);
					out.setLength(out.length()-1);
				}

				//If you have right parantheses
				if(r > l)
				{
					out.append(")");
					printParantheses(l, r-1, out);
					out.setLength(out.length()-1);
				}
			}				
		}	
	}









