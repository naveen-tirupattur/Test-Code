/**
 * Main class to call all other example classes
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {12, 4, 78, 90, 45, 23};
		System.out.println("Maximum Length is: "+MaxLengthBitonicArray.maxLength(a));
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
	public static void doCombine(char[] in, StringBuffer out, int length, int start, int newLength)
	{
		for(int i=start;i<length;i++)
		{
			out.append(in[i]);
			if(out.length() == newLength)
			{
			System.out.println(out);
			}
			
			if(i < length) doCombine(in,out,length,i+1,newLength);
			
			out.setLength(out.length() - 1);
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
}
