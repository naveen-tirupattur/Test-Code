/**
 * 
 */
package my.code;

import java.util.Random;

/**
 * @author Naveen Tirupattur
 *
 */
public class Singleton {
	
	public static Singleton instance;
	
	private Singleton(){ }
	
	public static Singleton getInstance()
	{
		if(instance == null)
		{
			synchronized(Singleton.class)
			{
				if(instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
