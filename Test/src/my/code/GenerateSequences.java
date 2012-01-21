/**
 * Class to generate all possible sequences of n numbers of length k
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class GenerateSequences {
	
	public static void generate(int a[], int n, int k, int index)
	{
		if(k==0) print(a, index);
		else
		for(int i=1;i<=n;i++)
		{
			a[index] = i;
			generate(a,n,k-1,index+1);
			
		}
	}
	
	public static void print(int a[], int index)
	{
		for(int i=0;i<index;i++)
		{
			System.out.println(a[i]);			
		}
		System.out.println("\n");
	}
	
	public static void generate1(int[] a, int n, int k)
	{
		for(int i=0;i<k;i++) a[i] = 1;
		
		while(true)
		{
			print(a,k);
			if(!hasNextSequence(a, n, k)) break;
		}
	}
	
	public static boolean hasNextSequence(int[] a, int n, int k)
	{
		int p = k-1;
		while( p >=0 && a[p] == n)
		{
			p--;
		}
		if( p < 0) return false;
		
		a[p] = a[p]+1;
		
		for(int i=p+1;i<k;i++) a[i] = 1;
		
		return true;
	}

}
