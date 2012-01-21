/**
 * Class to find maximum subsquare matrix 
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class MaximumSubSquareMatrix {

	public static void maxSquare(int[][] matrix)
	{
		
		int R = matrix.length;
		int C = matrix[0].length;
		int[][] newMatrix = new int[R][C];
		
		//Copy first column
		for(int i=0;i<R;i++)
		{
			newMatrix[i][0] = matrix[i][0];
		}
		
		//Copy first row
		for(int j=0;j<C;j++)
		{
			newMatrix[0][j] = matrix[0][j];		
		}
		
		//populate the other columns
		for(int i=1;i<R;i++)
		{
			for(int j=1;j<C;j++)
			{
				if(matrix[i][j] == 1) 
					newMatrix[i][j] = minimum(newMatrix[i][j-1], newMatrix[i-1][j], newMatrix[i-1][j-1]) + 1;
				else
					newMatrix[i][j] = 0;
			}
		}
		int max_i = R - 1;
		int max_j = C - 1;
		int max = newMatrix[max_i][max_j];
		for(int i = max_i;i >=0 ;i --)
		{
			for(int j=max_j;j>=0;j--)
			{
				if(newMatrix[i][j] > max)
				{
					max = newMatrix[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		for(int i=max_i;i>max_i - max;i--)
		{
			for(int j=max_j;j>max_j - max;j--)
			{
				System.out.println(matrix[i][j]);
			}
			System.out.println('\n');
		}
		
	}
	
	public static int minimum(int a, int b, int c)
	{
		int m = a;
		if(m > b) m = b;
		if(m > c) m = c;
		return m;
	}
		
}
