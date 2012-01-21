/**
 * Class to remove specified characters
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class RemoveSpecifiedCharacters {

	public static String remove(String originalString, String removeString)
	{
		char[] c = originalString.toCharArray();
		char[] r = removeString.toCharArray();
		boolean flag[] = new boolean[128];
		int src=0,dest=0;
		for(int i=0;i<removeString.length();i++) 
			{flag[r[i]] = true;}
		while(src<c.length)
		{
			if(!flag[c[src]]) 
				{
				c[dest++] = c[src];
				}
			src++;
		}
		return new String(c,0,dest);
	}
}
