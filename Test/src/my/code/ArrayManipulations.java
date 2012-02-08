/**
 * Class to find Maximum Element in array
 */
package my.code;

/**
 * @author Naveen Tirupattur
 *
 */
public class ArrayManipulations {

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

	//Rotate a matix by 90 degrees

	public static void rotateMatrix(int[][] matrix)
	{

		for(int i=0;i<matrix.length;i++)
		{
			for(int j=i+1;j<matrix[0].length;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for(int i=0;i<matrix.length;i++)
		{
			int start=0, end=matrix.length-1;
			while(start < end)
			{
				int tempV = matrix[i][start];
				matrix[i][start++] = matrix[i][end];
				matrix[i][end--] = tempV;				
			}
		}

		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				System.out.println(matrix[i][j]);
			}
			System.out.println("\n");
		}

	}

	public static int closestPair(int[] array)
	{
		int curr_min = Math.abs(array[1] - array[0]);

		for(int i=2;i<array.length;i++)
		{
			int temp_min = Math.abs(array[i] - array[i-1]);
			curr_min = Math.min(temp_min, curr_min);			
		}
		return curr_min;
	}

	//Check if no other queen exists on the same column and same diagonal
	public static boolean check(int row, int[] columnForRow)
	{
		for(int i=0;i<row;i++)
		{
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if(diff == 0 || diff == Math.abs(i-row)) return false;
		}
		return true;
	}

	//Place the queen
	public static void placeQueen(int row, int[] columnForRow)
	{
		if(row == 8)
		{
			return;
		}else
		{
			for(int i=0;i<8;i++)
			{
				columnForRow[i] = row;
				if(check(row, columnForRow))
				{
					placeQueen(row+1, columnForRow);
				}
			}
		}	
	}

	//Merge two sorted arrays
	int[] merge(int[] a, int[] b, int m, int n)
	{
		int end = m + n -1;
		while(m >=0 && n >=0)
		{
			if(a[m] > b[n]) a[end--] = a[m--];

			else

				a[end--] = b[n--];
		}

		while(m >= 0)
			{
				a[end--] = a[m--];
			}
		
		
		return a;
	}
	
	//Find an element in rotate sorted array in logn time
	public static int findElementInRotatedArray(int[] a, int l, int u, int x)
	{	
		while(l <= u)
		{
			//Find the middle element
			int m = (l+u)/2;
			
			if(a[m] == x) return m;
			
			//Check if lower half is sorted
			else if(a[l] <= a[m])
			{
				if(x < a[m] && x >= a[l]) u = m - 1;
				else
					l = m+1;
			}//Check if upper half is sorted
			else
			{
				if(x > a[m] && x <= a[u]) l = m+1;
				else
					u = m - 1;
			}
		}
		
		return -1;
	}

}
