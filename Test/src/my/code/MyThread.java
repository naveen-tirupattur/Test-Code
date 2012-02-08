/**
 * 
 */
package my.code;

import java.util.Random;

/**
 * @author Naveen Tirupattur
 *
 */
public class MyThread implements Runnable {

	public String name="";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread: "+getName());		
		System.out.println("Singleton Instance: "+Singleton.getInstance());		
	}
	
	

}
