package exceptionsBasics;

import java.util.Scanner;

public class CustomExceptionUse
{
    public static void main(String[] args)
    {
          Scanner sc = new Scanner(System.in);  //Declaring Scanner variable to take input from user
 
          System.out.println("Enter Your Age");
 
          int age = sc.nextInt();         //Taking input from user
          
          sc.close();
 
          try
          {
              if(age < 0)
              {
                  throw new CustomAgeIsNegativeException("Age can not be negative");    //throws AgeIsNegativeException if age is negative
              }
              System.out.println("Thanks for entering valid age");
          }
          catch(CustomAgeIsNegativeException ex)
          {
              System.out.println(ex);    //Output : Age can not be negative
          }
    }
}