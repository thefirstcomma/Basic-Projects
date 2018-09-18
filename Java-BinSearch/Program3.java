/*
 * Author: Prof. Diaz
 * Class: CS 264
 *
 * Assignment: Program 3
 * Date Last Modified: 1/29/18
 *
 * Purpose: A program to work with arrays, allowing the user to remove or edit values and see the result.
 * When exiting, the program computes the sum and product of the remaining values.
 */
import java.util.Scanner;
public class Program3 {
    private static int[] array = new int[10]; // reserves a global array for 10 int values
 
    // method: main
// purpose: to manipulate an array
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // get ready to read in values
        int menuChoice = 0; // readies our choice from our menu
        System.out.print("Please enter 10 integer values: "); // ask the user for input, assume correct input
        for (int i = 0; i < array.length; i++)
            array[i] = input.nextInt(); // creates our array with the values given
        printArray(); // this will print out the initial values of the array for the user to see
        do { // this is our menu, we have the following options to manipulate the array
            System.out.println("Menu (enter an int as your choice): ");
            System.out.println("1) Replace an element at a certain position");
            System.out.println("2) Remove the max element ");
            System.out.println("3) Remove the min element ");
            System.out.println("4) Compute values and exit ");
            System.out.print("What would you like to do? ");
            menuChoice = input.nextInt();
            if (menuChoice == 1)
                replaceElement(); // does not have to implement a full method call
            if (menuChoice == 2)
                removeMax(); // just jump or branch to a correct
            if (menuChoice == 3)
                removeMin(); // section of code to perform each action
            if (menuChoice == 4)
                computeValues();
        } while (menuChoice != 4);
    }
 
    // method: replaceElement()
// purpose: ask the user for a position and replace the value in an array
// at that location with a new value
    public static void replaceElement() {
        int position = 0, newValue = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("What position from the array do you wish to replace? ");
        position = input.nextInt() - 1; // assume user doesn't start with 0 for counting
        System.out.print("What value to you want to change it to? ");
        newValue = input.nextInt();
        array[position] = newValue;
        printArray(); // just jump or branch to the appropriate section
    }
 
    // method: removeMax()
// purpose: removes the largest value from our array
    public static void removeMax() {
        int[] tempArray = new int[array.length - 1];
        int max = 0;
        for (int i = 1; i < array.length; i++)
            if (array[max] < array[i])
                max = i;
        for (int i = 0, j = 0; j < tempArray.length; i++, j++) {
            if (i == max)
                i++;
            tempArray[j] = array[i];
        }
        array = tempArray;
        printArray(); // just jump or branch to the appropriate section
    }
 
    // method: removeMin()
// purpose: removes the smallest value from our array
    public static void removeMin() {
        int[] tempArray = new int[array.length - 1];
        int min = 0;
        for (int i = 1; i < array.length; i++)
            if (array[min] > array[i])
                min = i;
        for (int i = 0, j = 0; j < tempArray.length; i++, j++) {
            if (i == min)
                i++;
            tempArray[j] = array[i];
        }
        array = tempArray;
        printArray(); // just jump or branch to the appropriate section
    }
 
    // method: computeValues()
// purpose: computes the summation and the product of all values in the
// array and prints them to the screen.
    public static void computeValues() {
        int sum = 0, product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            product *= array[i];
        }
        System.out.println("The summation of all values in the array is: " +
                sum + ", the product of all values in the array is: " + product);
    }
 
    // method: printArray()
// purpose: print out the array to the screen
    public static void printArray() {
        System.out.print("Your values are: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}