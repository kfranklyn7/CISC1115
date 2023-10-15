/**
 * @author Kevon Franklyn
 * @date 4/17/2023
 * @description
 * The program will scan a file, read the information into an array, sort the
 * list by the seating order provided then print the sorted list as well as
 * the total number of guests, the number of women and the number of men
 * invited
 * I solved this problem by using string concatenation and an if statement
 * to contain the name and title of the guests contained within the name array.
 * A separate array was used to contain the order of the guests and used to sort
 * them using the bubble sort method. The male and female guest lists were printed
 * using a method that checked if the string contained certain titles using the
 * string.contains method. These methods also returned that counted the number of
 * guests printed
 * I enjoyed this assignment as it gave me a better idea of how to manipulate strings
 * and use arrays, however, my laptop screen broke during the process so I am quite unhappy
 */
package homework5;

import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class Homework5 {
    static public PrintStream ps;

    public static void main(String[] args) throws Exception {
        final int MAX = 100;
        int count;
        int males, females, total;
        String[] name = new String[MAX];
        int[] order = new int[MAX];
        ps = new PrintStream("output.txt");

        count = populateArray(order, name);

        bubbleSort(order, name, count);
        
        ps.println("\t\tInvitation List");
        ps.println("Name \t\t\t\tSeat Number");
        for (int i = 0; i < count; i++) {
            ps.printf("%s   \t\t\t%d\n", name[i], order[i]);

        }
        males = genderMale(order,name,count);
        females = genderFemale(order,name,count);
        ps.printf("\nTotal Number of Guests:\t\t\t%d\nTotal Number "
        + "of Female Guests:\t\t%d\nTotal Number of Male Guests:\t\t%d",count,females,males);
        
        
        


    }
    //Method populates both arrays and assigns title to the name array
    public static int populateArray(int[] order, String[] name) throws Exception {
        Scanner sc = new Scanner(new File("party.txt"));

        int count = 0;
        int titlenum;
        String title;
        while (sc.hasNext()) {
            name[count] = sc.next();

            name[count] = name[count] + " " + sc.next();
            order[count] = sc.nextInt();
            titlenum = sc.nextInt();
            if (titlenum == 1) {
                title = "Mr.";
            } else if (titlenum == 2) {
                title = "Mrs."; 
            } else if (titlenum == 3) {
                title = "Ms.";
            } else {
                title = "Miss";
            }
            name[count] = title + " " + name[count];
            count++;
        }

        return count;

    }
    //Method sorts one array and switches the positions of both arrays accordingly
    public static void bubbleSort(int[] order, String[] name, int n) {
        int hold, j, pass;
        String temp;
        boolean switched = true;

        for (pass = 0; pass < n - 1 && switched; pass++) {
            switched = false;
            for (j = 0; j < n - pass - 1; j++) {
                if (order[j] > order[j + 1]) {
                    switched = true;
                    hold = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = hold;
                    temp = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temp;
                }
            }

        }

    }
    //Method prints list of male guests and returns the number of male guests
    public static int genderMale(int[] order, String[] name, int count) throws Exception {
    Scanner sc = new Scanner(new File("party.txt"));
    int titlenum, males = 0; 
    ps.println("\n\t\tMale Guests");
        for (int n = 0; n < count; n++) {
            

            if (name[n].contains("Mr.")) {
                ps.printf("%s   \t\t\t%d\n", name[n], order[n]);
                males++;
            }
        }


    return males;
}
    //Method prints lost of female guests and returns the number of female guests
    public static int genderFemale(int[] order, String[] name, int count) throws Exception {
    Scanner sc = new Scanner(new File("party.txt"));
    int titlenum, males = 0; 
    ps.println("\n\t\tFemale Guests");
        for (int n = 0; n < count; n++) {
            

            if (!name[n].contains("Mr.")) {
                ps.printf("%s   \t\t\t%d\n", name[n], order[n]);
                males++;
            }
        }


    return males;
}


}
