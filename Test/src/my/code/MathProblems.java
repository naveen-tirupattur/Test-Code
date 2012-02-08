/**
 * Math problems
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class MathProblems {

	public static boolean isPalindrome(int x)
	{

		if(x < 0) return false;

		if(x == 0) return true;

		int div = 1;

		while( x/div >= 10) div*= 10;

		while(x!=0)
		{
			int l = x/div;
			int r = x%10;

			if(l !=r) return false;

			x = (x%div)/10;
			div /= 100;

		}
		return true;
	}

	//Make change
	public static int makeChange(int n, int denom) {

		int next_denom = 0;
		switch(denom)
		{
			case 25: 
				next_denom = 10;
				break;

			case 10: 
				next_denom = 5;
				break;
			
			case 5:
				next_denom = 1;
				break;

			case 1: 
				return 1;
		}
		int ways = 0;
		
		for(int i=0;i*denom <= n;i++)
		{
			ways += makeChange(n - i*denom,next_denom);
		}
		return ways;
	}
	
	//make change again
	public static int makeChangeAgain(int[] s, int m, int n)
	{
		if(n == 0) return 1;
		
		if(n < 0) return 0;
		
		if(m <= 0 && n >= 1) return 0;
		
		return makeChangeAgain(s,m-1,n)+makeChangeAgain(s,m,n-s[m-1]);
	}




}
