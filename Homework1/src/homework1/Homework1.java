/**
 *
 * @author Kevon Franklyn
 * @since 02-13-2023
 *
 * The program should accept the radius of a torus and the radius 
 * of the tube of the torus. The program should output the 
 * volume of the torus as well as its surface area and 
 * the area of the hole. The program should be 
 * stopped using the trailer method.
 * I solved this by scanning the inputs the two radii to radtor and 
 * radtube, multiplying them with the constant PI as the formulas 
 * called for. 
 * I used PrintStream to output the results to a file. 
 * Since there were multiple sets of data, I used a while loop to calculate 
 * and print the results of each.
 * I formatted the output to 1 decimal place to account 
 * for the data set provided and assigned all the variables as double
 * I had a decent amount of fun with this program as I got to practice 
 * using printf for formatting the results. 
 * I found the calculation portion a bit
 * tedious since we presently don't know how to raise numbers to exponents
 * but easy since the formulae was provided.
 */
package homework1;

import java.util.Scanner;
import java.io.PrintStream;

public class Homework1 {

    public static void main(String[] args) throws Exception {
        double radtube, radtor, vol, area, hole;
        final double PI = 3.141;

        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream("output.txt");

        prompt();

        radtube = sc.nextDouble();
        while (radtube > 0) {
            radtor = sc.nextDouble();

            area = 4 * PI * PI * radtor * radtube;
            vol = 2 * PI * PI * radtor * radtube * radtube;
            hole = PI * (radtor - radtube) * (radtor - radtube);

            System.out.printf("When the radius of the torus (R)"
                    + "is %.1f cm and the radius of the tube (r) is "
                    + "%.1f cm %n"
                    + "the volume of a torus is the %.1f cm squared and"
                    + " its surface area "
                    + "is %.1f cc %n" + "The area of the hole"
                    + " is %.1f cm squared. %n%n",
                    radtor, radtube, vol, area, hole);

            ps.printf("When the radius of the torus (R)"
                    + "is %.1f cm and the radius of the tube (r) is "
                    + "%.1f cm %n"
                    + "the volume of a torus is the %.1f cm squared "
                    + "and its surface area "
                    + "is %.1f cc %n" + "The area of the hole"
                    + " is %.1f cm squared. %n%n",
                    radtor, radtube, vol, area, hole);

            prompt();

            radtube = sc.nextDouble();
        }
    }

    public static void prompt() {// Prompts the user to input radii
        System.out.println("Enter the radius of the tube ");
        System.out.println("Enter the distance from the "
                + "center of the torus");
        System.out.println("to the center of the tube");
        System.out.println("Enter 0 twice to stop");

    }
}
