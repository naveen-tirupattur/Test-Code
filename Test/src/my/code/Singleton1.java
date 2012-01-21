/**
 * 
 */
package my.code;

/**
 * @author Naveen
 *
 */
public class Singleton1
{
	public static Singleton1 instance;
	private Singleton1()
	{
		
	}
	
	private static class SingletonHolder
	{
		public static Singleton1 instance = new Singleton1();
	}
	
	public static Singleton1 getInstance()
	{
		return SingletonHolder.instance;
	}
}
