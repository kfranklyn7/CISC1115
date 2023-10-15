/**
 *@author Kevon Franklyn
 * @date 5/15/2023
 * @description The program reads a list of articles, nouns, verbs and
 * preposition and places them into an array. While being added to the array, a
 * counter is incremented. The counter for each noun as well as a random number
 * generator are used to randomly generate sentences I solved this program by
 * using 4 methods to populate the arrays as well as count the number of
 * elements for each. I then used a for loop to print the number of sentences. I
 * wanted I concatenated the arrays along with a randomly generated number for
 * each element to randomize the sentences I also split the article of each
 * sentence into a substring so I could capitalize the first letter This program
 * was fun to write, especially since I got to test randomly generated numbers I
 * also find it interesting how primitive this way of generating sentences is
 */
package homework61;

import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.Random;

public class Homework61 {

    static public PrintStream ps;
    static public Scanner sca;
    static public Scanner scn;
    static public Scanner scv;
    static public Scanner scp;

    public static void main(String[] args) throws Exception {
        final int MAX = 100;
        String sentence1, sentence2, sentence3, sentence4, sentence5;
        int counta, countn, countv, countp, numa, numn, numv, nump;

        String[] article = new String[MAX];
        String[] noun = new String[MAX];
        String[] verb = new String[MAX];
        String[] preposition = new String[MAX];
        counta = populateArrayA(article);
        countn = populateArrayN(noun);
        countv = populateArrayV(verb);
        countp = populateArrayP(preposition);
        Random rnd = new Random();            
        PrintStream ps = new PrintStream("output.txt");
        for (int i = 1; i <= 4; i++) {
            String articlef, capital;

            sentence1 = noun[rnd.nextInt(0, countn)] + " " + verb[rnd.nextInt(0, countv)] + " " + preposition[rnd.nextInt(0, countp)] + " " 
            + article[rnd.nextInt(0, counta)] + " " + noun[rnd.nextInt(0, countn)] + ".";
            articlef = article[rnd.nextInt(0, counta)];
            capital = articlef.substring(0, 1).toUpperCase() + articlef.substring(1);
            sentence1 = capital + " " + sentence1;
            sentence2 = noun[rnd.nextInt(0, countn)] + " " + verb[rnd.nextInt(0, countv)] + " " + preposition[rnd.nextInt(0, countp)] + " "
            + article[rnd.nextInt(0, counta)] + " " + noun[rnd.nextInt(0, countn)] + ".";
            articlef = article[rnd.nextInt(0, counta)];
            capital = articlef.substring(0, 1).toUpperCase() + articlef.substring(1);
            sentence2 = capital + " " + sentence2;
            sentence3 = noun[rnd.nextInt(0, countn)] + " " + verb[rnd.nextInt(0, countv)] + " " + preposition[rnd.nextInt(0, countp)] + " "
            + article[rnd.nextInt(0, counta)] + " " + noun[rnd.nextInt(0, countn)] + ".";
            articlef = article[rnd.nextInt(0, counta)];
            capital = articlef.substring(0, 1).toUpperCase() + articlef.substring(1);
            sentence3 = capital + " " + sentence3;
            sentence4 = noun[rnd.nextInt(0, countn)] + " " + verb[rnd.nextInt(0, countv)] + " " + preposition[rnd.nextInt(0, countp)] + " "
            + article[rnd.nextInt(0, counta)] + " " + noun[rnd.nextInt(0, countn)] + ".";
            articlef = article[rnd.nextInt(0, counta)];
            capital = articlef.substring(0, 1).toUpperCase() + articlef.substring(1);
            sentence4 = capital + " " + sentence4;
            sentence5 = noun[rnd.nextInt(0, countn)] + " " + verb[rnd.nextInt(0, countv)] + " " + preposition[rnd.nextInt(0, countp)] + " "
            + article[rnd.nextInt(0, counta)] + " " + noun[rnd.nextInt(0, countn)] + ".";
            articlef = article[rnd.nextInt(0, counta)];
            capital = articlef.substring(0, 1).toUpperCase() + articlef.substring(1);
            sentence5 = capital + " " + sentence5;
            ps.printf("%s%s%s%s%s\n", sentence1, sentence2, sentence3, sentence4, sentence5);
            System.out.printf("%s%s%s%s%s\n", sentence1, sentence2, sentence3, sentence4, sentence5);

        }

    }

    //Populates the array with articles and provides a counter for the number of articles
    public static int populateArrayA(String[] article) throws Exception {
        Scanner sca = new Scanner(new File("Article.txt"));

        int count = 0;
        while (sca.hasNext()) {
            article[count] = sca.next();
            count++;
        }

        return count;

    }
    //Populates the array with nouns and provides a counter for the number of nouns

    public static int populateArrayN(String[] noun) throws Exception {
        Scanner scn = new Scanner(new File("Noun.txt"));

        int count = 0;
        while (scn.hasNext()) {
            noun[count] = scn.next();
            count++;
        }

        return count;

    }
    //Populates the array with verbs and provides a counter for the number of verbs

    public static int populateArrayV(String[] verb) throws Exception {
        Scanner scv = new Scanner(new File("Verb.txt"));

        int count = 0;
        while (scv.hasNext()) {
            verb[count] = scv.next();
            count++;
        }

        return count;

    }
    //Populates the array with prepositions and provides a counter for the number of prepositions

    public static int populateArrayP(String[] preposition) throws Exception {
        Scanner scp = new Scanner(new File("Preposition.txt"));

        int count = 0;
        while (scp.hasNext()) {
            preposition[count] = scp.next();
            count++;
        }

        return count;

    }

}
