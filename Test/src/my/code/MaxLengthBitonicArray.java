/**
 * Class to find MaxLengthBitonicArray
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class MaxLengthBitonicArray {

	public static int maxLength(int[] a)
	{
		int n = a.length;	
		int[] asc = new int[n];
		int[] desc = new int[n];

		asc[0] = 1;
		desc[n-1] = 1;

		for(int i=1;i<n;i++) {
			if(a[i] > a[i-1]) asc[i] = asc[i-1]+1;
			else
				asc[i] = 1;
		}

		for(int i=n-2;i>=0;i--)
		{
			if(a[i] > a [i+1]) desc[i] = desc[i+1] + 1;
			else
				desc[i] = 1;
		}

		int max = asc[0] + desc[0] - 1;
		int index = 0;

		for(int i=1;i< n;i++)
		{
			int localMax = asc[i] + desc[i] - 1;
			if (localMax > max)
				{
					max = localMax;
					index = i;
				}

		}
		for(int i = index-asc[index]+1; i < index+desc[index];i++)
			System.out.println(a[i]);
		return max;

	}


}
