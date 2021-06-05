package exceptionsBasics;

public class Exceptions{
	  public static void main(String[] args)
	    {
	        System.out.println("This statement will be executed"); 
	 
	        try
	        {
	            //Integer I = new Integer("abc");  //This statement throws NumberFormatException
	            
	          //  int i = 200/0;
	            
	            String s = args[1];
	            
	            
	        }
	        catch (Exception e)
	        {
	        	
				/*
				 * e.getMessage(); System.out.println("\n"); e.printStackTrace();
				 * System.out.println("\n");
				 */
	        e.toString();
	            System.out.println("exception caught");
	       
	        }
	 
	        System.out.println("Now, This statement will also be executed");
	    }
	}