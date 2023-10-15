/**
 * @author Kevon Franklyn
 * @date 3/22/2023
 * @description The program accepts two values as the value of a two dice
 * then calculates whether or not the value fall within the valid range
 * The program then calculates whether or not the user has won
 * and creates values for a new dice roll based on the original values
 * The program calculates whether or not the computer has won or not
 * The program stores the win, loss and draw for both the user
 * and the computer then prints the results when the
 * trailer method is used  to stop the program
 * Methods are used to calculate the outcome and determine whether 
 * values are valid or not as well as prompt the user
 * I used a while loop to contain the user input and the increments of
 * the statistics counted nested within another while loop
 * to only continue the program when the values of double 7 aren't used
 * The validity of the values entered are checked by 2 boolean statements
 * within the valid method 
 * The outcome is checked by several if statements
 * within the outcome method with an integer being returned to represent
 * wins,losses and draws for both the user and computer
 * I also initialized the dice to a value of 1 to contain all 
 * the user input within the confines of the while loop
 * I spent little time on this program relative to the other homework
 * assignments so it is safe to say I enjoyed this one
 * It has given me practice on how to create 
 * and invoke methods in addition
 * to the main method without the need for global or class variables
 * I just wish I didn't have to manually input the
 * values multiple times for troubleshooting
 */
package homework3;

import java.io.PrintStream;
import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) throws Exception {
        int die1, die2, die3, die4, win1, loss1, draw1,
        win2, loss2, draw2,doublewin,doubleloss,doubledraw;
        win1 = 0;
        loss1 = 0;
        draw1 = 0;
        win2 = 0;
        loss2 = 0;
        draw2 = 0;
        doublewin = 0;
        doubleloss = 0;
        doubledraw = 0;
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream("output.txt");
        die1 = 1;
        die2 = 1;
        valid(die1,die2);
        while (!(die1 == 7 && die2 == 7)) {
            if (valid(die1, die2) == true) {
                while (valid(die1, die2) == true) {
                    promptUser();
                    die1 = sc.nextInt();
                    die2 = sc.nextInt();
                    System.out.println("\nDie 1 is " + die1 + 
                            " and die 2 is  " + die2);
                    ps.println("\nDie 1 is " + die1 + 
                            " and die 2 is  " + die2);
                    valid(die1, die2);
                    System.out.println("Your combination is valid");
                    ps.println("Your combination is valid");
                    if (outcome(die1, die2) == 1) {
                        System.out.println("You have won");
                        ps.println("You have won");
                        win1++;
                    } else if (outcome(die1, die2) == 2) {
                        System.out.println("You have lost");
                        ps.println("You have lost");
                        loss1++;
                    } else if (outcome(die1, die2) == 3) {
                        System.out.println("You have drawed");
                        ps.println("You have drawed");
                        draw1++;
                    }
                    die3 = die1 + 2;
                    if (die3 > 6) {
                        die3 = die3 - 6;
                    }
                    die4 = die2 + 3;
                    if (die4 > 6) {
                        die4 = die4 - 6;
                    }
                    System.out.println("\nDie 1 is " + die3 + 
                            " and die 2 is  " + die4);
                    ps.println("\nDie 1 is " + die3 + 
                            " and die 2 is  " + die4);
                    if (outcome(die3, die4) == 1) {
                        System.out.println("The computer has won");
                        ps.println("The computer has won");
                        win2++;
                    } else if (outcome(die3, die4) == 2) {
                        System.out.println("The computer has lost");
                        ps.println("The computer has lost");
                        loss2++;
                    } else if (outcome(die3, die4) == 3) {
                        System.out.println("The computer has drawed");
                        ps.println("The computer has drawed");
                        draw2++;
                    }
                    if (outcome(die1,die2)==1 && 
                            outcome(die3,die4)==1){
                    doublewin++;
                    } else if (outcome(die1,die2)==2 && 
                            outcome(die3,die4)==2){
                    doubleloss++;
                    } else if (outcome(die1,die2)==3 && 
                            outcome(die3,die4)==3){
                    doubledraw++;
                    }

                }

            } else {
                System.err.println("Your combination is invalid");
                ps.println("Your combination is invalid");
                System.out.println("Input two integers greater"
                        + " than 0 and less than 7");
                ps.println("Input two integers greater "
                        + "than 0 and less than 7");
                die1 = sc.nextInt();
                die2 = sc.nextInt();
                valid(die1, die2);
            }
        }
        System.out.printf("\nThe player has won %d times, "
                + "lost %d times and has drawn %d times"
                ,win1,loss1,draw1);
        ps.printf("\nThe player has won %d times,"
                + " lost %d times and has drawn %d times"
                ,win1,loss1,draw1);
        System.out.printf("\nThe computer has won %d times,"
                + " lost %d times and has drawn % d times",
                win2,loss2,draw2);
        ps.printf("\nThe computer has won %d times,"
                + " lost %d times and has drawn % d times"
                ,win2,loss2,draw2);
        System.out.printf("\nThe number of double wins is %d,"
                + " the number of double losses is %d"
                + " and the number of double draws is %d",
                doublewin,doubleloss,doubledraw);
        ps.printf("\nThe number of double wins is %d,"
                + " the number of double losses is %d"
                + " and the number of double draws is %d",
                doublewin,doubleloss,doubledraw);
    }

    public static void promptUser() {
        System.out.println("Enter a value within the range of 1-6");
        System.out.println("Input 7 for both die to stop playing");
        

    }

    public static boolean valid(int die1, int die2) {
        boolean proper;
        proper = true;
        if (die1 > 6 || die1 < 1) {
            proper = false;
        } else if (die2 > 6 || die2 < 1) {
            proper = false;
        }
        return proper;
    }

    public static int outcome(int die1, int die2) {
        int sum, score;
        score = 0;
        sum = die1 + die2;
        if (sum == 5 || sum == 7 || sum == 12) {
            score = 1;
        } else if (sum == 2 || sum == 4 || sum == 11) {
            score = 2;
        } else {
            score = 3;
        }
        return score;
    }

}
