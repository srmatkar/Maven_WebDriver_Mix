package exceptionsBasics;

public class ExceptionHierarchy
{
    public static void main(String[] args)
    {
        try
        {
            int i = Integer.parseInt("abc");   //This statement throws NumberFormatException
        }
 
        catch(NumberFormatException ex)
        {
            System.out.println("This block handles NumberFormatException");
        }
 
        catch(Exception ex)
        {
            System.out.println("This block handles all exception types");
        }
        catch (Throwable ex)
        {
            System.out.println("Throwable is super class of Exception");
        }
 
       
    }
}
