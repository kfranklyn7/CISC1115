/**
 *
 * @author Kevon Franklyn
 * @date 3/4/2023
 * @description The program should accept and scan through a file 
 * containing the inventory number, quantity and price of items 
 * in an order. The program should process the final price of each
 * item based on the amount of items ordered and apply a discount
 * as necessary. The program should also add a discount or
 * service charge depending on the balance. Finally, the program should
 * print and output the discount applied, the discounted price,
 * the original price, the inventory number and the item amount 
 * as well as the final balance. 
 * A message should also be included if the discount or service 
 * charge was applied.
 * I made a while loop under the condition of the file having more 
 * numbers to scan. I initialized the variables that aren't assigned 
 * through the scanner before creating the loop. 
 * At the start of the loop, the program scans the inventory number
 * as an integer and only processes the line if the inventory
 * number is greater than 0, otherwise it will print the final balance.
 * I used if statements to determine what type of discount should be 
 * applied based on the amount of items. Otherwise, it prints the final
 * balance based on an accumulated sum with the service charge or 
 * discount applied as necessary. I used a counter to print the heading
 * a certain amount of times. I assigned the totals to 0 at the end of
 * the loop, and the amount and item price at the beginning of the loop
 * to make sure none of the values would carry over between each order
 * I wish I used less if statements throughout the program and 
 * found a way to divide the parts into more methods. I found most 
 * of the difficulty in formatting the output and making sure the 
 * discounts were applied properly once I got the while loop to work
 *
 *
 */
package homework2;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) throws Exception {
        int invnumber, discount, count, itemtotal;
        double price, amount, itemprice, discprice, nettotal, grosstotal;

        Scanner sc = new Scanner(new File("crooked.txt"));
        PrintStream ps = new PrintStream("crookedsales.txt");

        nettotal = 0;
        count = 0;
        itemtotal = 0;
        grosstotal = 0;

        ps.println("\nNumber \t Amount \t Old Price\t"
                + "\tDiscount \tNew Price\n");
        while (sc.hasNext()) {
            invnumber = sc.nextInt();

            if (invnumber > 0) {
                amount = 0;
                itemprice = 0;
                amount = sc.nextDouble();
                price = sc.nextDouble();
                itemprice = amount * price;
                grosstotal += itemprice;
                itemtotal += amount;

                if (amount < 31) {
                    discprice = itemprice * 0.95;
                    discount = 5;
                    ps.printf("%4d\t %4.0f\t\t $%7.2f\t\t%3d%%\t"
                    + "\t$%7.2f\n"
                    + "", invnumber, amount, itemprice,
                discount, discprice);
                    nettotal += discprice;
                } else if (amount < 51 && amount > 30) {
                    discprice = itemprice * 0.9;
                    discount = 10;
                    ps.printf("%4d\t %4.0f\t\t $%7.2f\t\t%3d%%\t"
                    + "\t$%7.2f\n", invnumber, amount, itemprice, 
               discount, discprice);
                    nettotal += discprice;
                } else if (amount < 76 && amount > 50) {
                    discprice = itemprice * 0.75;
                    discount = 25;
                    ps.printf("%4d\t %4.0f\t\t $%7.2f\t\t%3d%%\t"
                    + "\t$%7.2f\n", invnumber, amount, 
               itemprice, discount, discprice);
                    nettotal += discprice;
                } else {
                    discprice = itemprice * 0.6;
                    discount = 40;
                    ps.printf("%4d\t %4.0f\t\t $%7.2f\t\t%3d%%\t"
                    + "\t$%7.2f \n", invnumber, amount, 
               itemprice, discount, discprice);
                    nettotal += discprice;
                }
            } else {
                if (grosstotal >= 500 && itemtotal < 50) {
                    count++;
                    nettotal = nettotal * 0.95;
                    ps.printf("\n\n\n\nThe final balance"
                    + " is $%.2f\n", nettotal);
                    ps.println("5% Discount\n\n\n\n\n");

                    if (count < 10) {
                      ps.println("\n\n\n\nNumber \t Amount \t Old Price\t"
                           + "\tDiscount \tNew Price\n");
                    }
                } else if (nettotal > 0 && grosstotal < 500) {
                    count++;
                    nettotal += 20;
                    ps.printf("\n\n\n\nThe final balance is"
                            + " $%.2f\n", nettotal);
                    ps.println("$20 Service Charge\n\n\n\n\n");

                    if (count < 10) {
                        ps.println("\nNumber \t Amount \t Old Price\t"
                                + "\tDiscount \tNew Price\n");
                    }
                } else if (nettotal > 0) {
                    count++;
                    ps.printf("\n\n\n\nThe final balance is"
                            + " $%.2f\n\n\n\n\n", nettotal);

                    if (count < 10) {
                        ps.println("\nNumber \t Amount \t Old Price\t"
                                + "\tDiscount \tNew Price\n");
                    }
                }

                grosstotal = 0;
                nettotal = 0;
                itemtotal = 0;

            }

        }

    }

}
