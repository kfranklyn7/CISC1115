/**
 * @author Kevon Franklyn
 * @date 4/17/2023
 * @description The program accepts the length, width, price per square foot and
 * discount of a carpet order. The labor cost, area, carpet price, installed
 * cost, subtotal, discount amount, tax and final cost are all calculated using
 * multiple methods. The heading and charges are printed using two separate
 * methods I made a while loop to contain the input of the data and iterate
 * through each method for the data sets.I stopped the loop using the trailer
 * method. Variables are sent to methods, calculated, and the values returned
 * are stored for use in other methods.Printf is used to format the invoice into
 * columns along with \t and \n. This program helped me to realize how useful
 * dividing programs into smaller methods are, however, I disliked having to
 * manually format the output in to columns and found the process finicky.
 */
package homework4;

import java.util.Scanner;
import java.io.PrintStream;

public class Homework4 {

    public static PrintStream ps;

    public static void main(String[] args) throws Exception {
        final double TAX = 0.085;
        final double LABOR = 0.35;
        int length, width, discount;
        double carpetper, price, laborcost, installedcost, 
        discountamount, subtotal, taxamount, finalcost;
        length = 1;
        ps = new PrintStream("output.txt");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Terminate the program by inputting a length less"
                + " than 0 \nLength of room (feet)?");
        length = sc.nextInt();
        while (length > 0) {
            System.out.printf("\nWidth of room (feet)?");
            width = sc.nextInt();
            System.out.printf("\nCustomer discount (percent)?");
            discount = sc.nextInt();
            System.out.printf("\nCost Per square foot (xxx.xx)?");
            carpetper = sc.nextDouble();
            price = calcPrice(length, width, carpetper);
            laborcost = calcLaborCost(length, width, LABOR);
            installedcost = calcInstalledPrice(laborcost, price);
            discountamount = calcDiscount(installedcost, discount);
            subtotal = calcSubTotal(installedcost, discountamount);
            taxamount = calcTax(subtotal, TAX);
            finalcost = subtotal + taxamount;
            Heading(length, width);
            Charges(carpetper, price, LABOR, laborcost, installedcost,
                    discount, discountamount, subtotal, taxamount, finalcost);
            System.out.printf("Terminate the program by inputting"
                    + " a length less than 0");
            System.out.printf("\nLength of room (feet)?");
            length = sc.nextInt();
        }
    }

    //Method calculates the price using the carpet price,length and width
    public static double calcPrice(int length, int width, double carpetper) {
        double price;
        int squarefeet;
        squarefeet = length * width;
        price = squarefeet * carpetper;
        return price;
    }

    //Calculates the labor cost based on the length and width
    public static double calcLaborCost(int length, int width, double LABOR) {
        double laborcost;
        int squarefeet;
        squarefeet = length * width;
        laborcost = LABOR * squarefeet;
        return laborcost;
    }

    //Calculates the cost to install the carpet
    public static double calcInstalledPrice(double laborcost, double price) {
        double installedcost;
        installedcost = laborcost + price;
        return installedcost;
    }

    //Calculates the discount applicable to the customer 
    public static double calcDiscount(double installedcost, int discount) {
        double discountpercent, discountamount;
        discountpercent = discount * 0.01;
        discountamount = installedcost * discountpercent;
        return discountamount;
    }

    //Calculates the subtotal based on the discount and installed cost
    public static double calcSubTotal(double installedcost,
            double discountamount) {
        double subtotal;
        subtotal = installedcost - discountamount;
        return subtotal;
    }

    //Calculates the taxes due based on the subtotal
    public static double calcTax(double subtotal, double TAX) {
        double taxamount;
        taxamount = subtotal * TAX;
        return taxamount;
    }

    //Prints the heading of the invoice as well as the legnth, width and area
    public static void Heading(int length, int width) throws Exception {
        ps.printf("\t\t        THE BROOKLYN COLLEGE CARPET STORE");
        ps.printf("\n\t\t\t    Kevon Franklyn,Owner");
        ps.printf("\n\n\t\t\t\tMEASUREMENT");
        ps.printf("\n\n\t\t\t  Length\t%3d feet", length);
        ps.printf("\n\t\t\t  Width \t%3d feet", width);
        ps.printf("\n\t\t\t  Area  \t%3d square feet", width * length);
    }

    //Prints the charges applicable to the customer
    public static void Charges(double carpetper, double price, double LABOR,
    double laborcost, double installedcost, int discount, double discountamount,
    double subtotal, double taxamount, double finalcost) throws Exception {
        ps.printf("\n\n\t\t\t\t  CHARGES\n\n\t\tDescription\tCOST/SQ.FT."
        + "\t\t CHARGE/ROOM\n\t\tCarpet\t\t%8.2f\t\t   $%8.2f", carpetper, price);
        ps.printf("\n\t\tLabor\t\t%8.2f\t\t    %8.2f\n\t\t\t\t\t\t\t    --------", LABOR, laborcost);
        ps.printf("\n\t\tINSTALLED PRICE\t\t\t\t   $%8.2f", installedcost);
        ps.printf("\n\t\tDiscount      %8d.0%%\t\t    %8.2f", discount, discountamount);
        ps.printf("\n\t\t\t\t\t\t\t    --------\n\n\t\tSUBTOTAL\t\t\t\t"
        + "   $%8.2f\n\t\tTax \t\t\t\t\t    %8.2f\n\t\tTOTAL\t\t\t\t\t"
        + "   $%8.2f\n\n\n\n\n\n\n\n\n\n", subtotal, taxamount, finalcost);
    }
}
