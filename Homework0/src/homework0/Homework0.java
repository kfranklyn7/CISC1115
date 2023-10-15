/**
 * @author Kevon Franklyn
 * @since 02-06-2023
 * 
 * The program should accept two variables, first for the user's first name
 * and last for the user's last name then print the phrases:
 * "This is my first program" along with the user's name
 * 
 * The scanner function is imported to allow the user to input their name.
 * The variables first and last are declared.
 * The user is prompted to enter their first and last name as well as 
 * reminded to press Enter to properly input their name.
 * A scanner is used to assign the two strings inputted to the variables
 * first and last to later be printed as their first and last name.
 * 
 * I didn't have much thoughts on the program as I didn't write it.
 * I was surprised to see concatenation being used for formatting.
 */
package homework0;

import java.util.Scanner;

public class Homework0 {

    public static void main(String[] args) {
        String first,last;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your first and your last name.");
        System.out.println("Do not forget to press the ENTER key.");
        
        first=sc.next();
        last=sc.next();
        
        System.out.println("\nThis is my first program!");
        System.out.println("My name is:"+first+" "+last);
        
    }
    
}
