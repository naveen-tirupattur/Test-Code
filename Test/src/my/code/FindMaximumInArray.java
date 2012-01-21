/**
 * Class to find Maximum Element in array
 */
package my.code;

/**
 * @author Naveen Tirupattur
 *
 */
public class FindMaximumInArray {
	
	public static int findMaximum(int[] a)
	{
		int max = 0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i] > max) max = a[i];
		}
		return max;
	}
	
	public static int findMaximumBinarySearch(int[] a, int start, int end)
	{
		int mid = (end + start)/2;
		if(a[mid] > a[mid -1] && a[mid] > a[mid+1]) return a[mid];
		else
			if(a[mid] > a[mid-1] && a[mid] < a[mid+1])
				return findMaximumBinarySearch(a, mid+1, end);
			else 
				return findMaximumBinarySearch(a, start, mid-1);
			
	}

}
