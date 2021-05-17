/**
 * @author: Brandon Nunez
 * DATE: April 10th, 2021
 * HOURS: 8
 * CLASS: CSCIU200-01W
 * ASSIGNMENT: Project 4
/* This program reads in the file fractions.txt, prompts
the user to input a float point decimal value, and prints out
the fraction and value in fractions.txt that is closest to
the float point value inputted by the user.*/
/*This program was difficult for me at first as it was my first
time implementing interfaces into my program, as well as creating 
my own compareTo method to be used in the sorting of the fractions
and their values. Ultimately, I'm happy with the results of the
program and found myself enjoying it more than other programs I've
worked on in the past.*/

import java.util.Scanner;
import java.util.Collections;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;        

public class FractionMatcher
{

   public static void main(String[] args) throws IOException
   { /* Declares the variables and scanners needed to read the lines
    from fractions.txt, as well as declares the ArrayLists 
    used in the program. */
    String fraction;
    Scanner scan = new Scanner(System.in);
    Scanner fileScan, fractionScan;
    ArrayList<Fraction> fractionArray = new ArrayList<Fraction>();
    ArrayList<Double> fractionValueArray = new ArrayList<Double>();


    fileScan = new Scanner(new File("fractions.txt"));

    /*Reads and processes each line of the file fractions.txt.*/
    while (fileScan.hasNext()) { 
        fraction = fileScan.nextLine();

        /*Splits the lines in fractions.txt into two
        seperate strings.*/
      
        fractionScan = new Scanner(fraction);
        String[] fract = fraction.split("/"); 

        /*Turns the two split strings from the scanned
        line in fractions.txt into two integers.*/
        int fractionInt1 = Integer.parseInt(fract[0]);
        int fractionInt2 = Integer.parseInt(fract[1]); 
        
        /*Puts the value of the fraction, as well as its quotient, into
       two seperate ArrayLists that will be used in the program.*/
        Fraction fractionList = new Fraction(fractionInt1, fractionInt2);
        fractionArray.add(fractionList);
        double fractionListValue = ((double)fractionInt1/(double)fractionInt2);
        fractionValueArray.add(fractionListValue); 
        }
        
    /* Sorts the arraylists containing the fractions in
    fractions.txt, as well as their values.*/
    Collections.sort(fractionValueArray);  
    Collections.sort(fractionArray);

    /*Prompts the user for decimal input and scans the
    next float value.*/
    System.out.print("Enter a decimal number: ");
    double prmpt = scan.nextFloat();

        /*Runs through the code if the float point value is
        not equal to zero. */
        if(prmpt != 0) {
            /*Creates a do loop that prints out the closest
            fraction and its respective value while the user
            continues to input a float value not equal to zero.*/
            do {
            /*Prints the first fraction and its value if the
            prompted float value is a negative number.*/
             if(prmpt < 0) {
                    System.out.println("Closest: " + fractionArray.get(0)
                    + " (" + fractionValueArray.get(0) + ")");
                }
            /*Prints the final fraction and its value if the prompted
            float value is a positive integer.*/
            else if(prmpt >= 1) {
                    System.out.println("Closest: " + fractionArray.get(79)
                    + " (" + fractionValueArray.get(79) + ")");
                }
            else {
            /* Creates a for loop that has 80 iterations, one for each
            of the fraction values found in fractions.txt.*/
            for(int i = 0; i < 79; i++){ 
                /* Calculates which two fraction values the prompted
                float value is between, and prints out the closest
                fraction and its value if it has the smaller difference
                value.*/
                if(Math.abs(prmpt - fractionValueArray.get(i)) < 
                Math.abs(prmpt - fractionValueArray.get(i+1)) && prmpt >= fractionValueArray.get(i)
                && prmpt <= fractionValueArray.get(i+1)){
                    System.out.println("Closest: " + fractionArray.get(i)
                    + " (" + fractionValueArray.get(i) + ")"); 
                    }
                else {
                    /* Runs through the code and prints out the second 
                    fraction value that the prompted float value was between
                    if it had the smaller absolute value difference.*/
                    if(Math.abs(prmpt - fractionValueArray.get(i)) >
                Math.abs(prmpt - fractionValueArray.get(i+1)) && prmpt > fractionValueArray.get(i)
                && prmpt < fractionValueArray.get(i+1)) {
                    System.out.println("Closest: " + fractionArray.get(i+1)
                    + " (" + fractionValueArray.get(i+1) + ")");
                            }   
                        }
                    }
                }
            /* Prompts the user to enter another decimal float
            point as long as the input is not equal to zero,
            thanks to the do-while loop.*/
            System.out.print("Enter a decimal number: ");
            prmpt = scan.nextFloat();
            }
            while(prmpt != 0);
        }
    }
}

   