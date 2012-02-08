/**
 * Permutations of a string
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class Permutation {

	/**
	 * @param args
	 */
	
	public static void permutation(String str)
	{
		int length = str.length();
		boolean used[] = new boolean[length];
		StringBuffer out = new StringBuffer();
		doPermute(str,out,used,length,0);
	}

	public static void doPermute(String inputString,StringBuffer outputString,boolean[] used,int length, int level)
	{
		if(level == length)
		{
			System.out.println(outputString);
			return;
		}
		for(int i=0;i<length;i++)
		{
		if(used[i]) continue;
		outputString.append(inputString.charAt(i));
		used[i]=true;
		doPermute(inputString,outputString,used,length,level+1);
		used[i]=false;
		outputString.setLength(outputString.length() - 1);
		}
	}

	public static void permutation1(String startString, String endString)
	{
		int n = endString.length();
		if(n==0) System.out.println(startString);
		else
			for(int i=0;i<n;i++)
				permutation1(startString+endString.charAt(i),endString.substring(0,i)+endString.substring(i+1,n));
		
	}
	
}
