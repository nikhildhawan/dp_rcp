package org.iiitb.assignment.mt2011090_rcp.myutil;

public class Logger
{
	static boolean devmode=true; // one click stops all logging
	
	public static void log(String message)	//change implementation to change the way logs are displayed / stored.
	{
		if(devmode){
			
			System.out.println(message);
		
		}
	}

}
