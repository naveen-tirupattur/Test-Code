/**
 * 
 */
package my.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Naveen
 *
 */
public class AnagramComparator implements Comparator<String>
{

	public String sortChars(String s)
	{
		char[] c =s.toCharArray();		
		Arrays.sort(c);
		return new String(c);
	}

	
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return sortChars(s1).compareTo(sortChars(s2));
	}
}

