/**
 *      Name:           Andrew Kim
 *      Date:           04.25.2018
 *      Class:          CS-241-01
 *      Description:    Utilizing an arraylist to test the BinarySearch class and creating Binary trees
 *                      that organizes data in a newer non-linear manner. Menu input is also offered here.
 *
 */
 
import java.io.*;
import java.util.*;
 
public class Main {

    //created the arraylist as a global static field
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    //Instance
    static BinarySearch inst = new BinarySearch();
 
    //main method here, important if .jar file is executable
    public static void main(String[] args) {
 
        start();
 
        System.out.print("\nPre-Order: ");
        inst.preOrder();
        
        System.out.print("\nIn-Order: ");
        inst.inOrder();
 
        System.out.print("\nPost-Order: ");
        inst.postOrder();
 
        System.out.println("\n-----------------");
        System.out.println("Main Menu\n" + "A : Add a value\n" + "R : Remove a value\n" + "E : Exit the program");
        System.out.println("-----------------");

        menu();
    }
 

    public static void start() {

        //Scanner input variable
        Scanner scan = new Scanner(System.in);
        String input;
 
        // Gather user-inputs
        System.out.println("Please enter values: ");
        input = scan.nextLine();
 
        // String array that is created by separating white-spaces from the String input.
        String[] tempArray = input.split(" ");
 
        for(int i = 0; i < tempArray.length; i++) {
            // Copy the values from the String array to the Integer ArrayList while parsing for correct storage
            numbers.add(Integer.parseInt(tempArray[i]));
        }

        //calls checkDuplicates from the BinarySearch class, returns true if duplicates exist, false otherwise
        if(inst.checkDuplicates(numbers) == true) {
            System.out.println("Duplication values are not allowed! Please enter values:\n");

            //clear out the arraylist, since duplicates were input and stored
            numbers.clear();
            //ask for the tree value again.
            start();

        } else {

            //for loop traversing through the arraylist
            for(int i = 0; i < numbers.size(); i++) {
                //BinarySearch method add(T entry) to enter into a Binary Tree
                inst.add(numbers.get(i));
            }
 
        }
    }
 
    /**
     * Creates the main menu within the console for user-input
     */
    public static void menu() {
        //Scanner variable, could've used static scanner variable but was getting some error
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What command would you like to run?");
 
        //prompt user for Strin ginput
        String menuInput = scan.nextLine();
        int inputValue;

        //tests for user-input for values of 'a' upper or lower case
        if(menuInput.equals("A") || menuInput.equals("a")) {
            System.out.print("\nPlease enter a value to add: ");
            //Another input is needed for what value to add
            inputValue = scan.nextInt();

            //adds the value to the arraylist
            numbers.add(inputValue);

            //checks the arraylist for duplicates now, returns true if duplicates exist and false otherwise
            if(inst.checkDuplicates(numbers) == true) {
                System.out.println("Can't enter Duplicates! Try Again!");
                //removes all instances of the value that was taken as an input. 
                //We do this since a duplicate will appear. We also can't use the method remove() easily
                //because remove() gets rid of the element at the stated index. not the value itself, which is why
                //I used Arrays.asList()
                numbers.removeAll(Arrays.asList(inputValue));
                //prompt menu again, since failed duplicate test
                menu();
            } else {
                //adds to arraylist
                inst.add(inputValue);
                System.out.println("\nIn-Order: ");
                //prints the inorder value from the BinarySearch class
                inst.inOrder();
                System.out.println();
                //prompts menu for other uses to the tree
                menu();
            }

        //tests for user-input for values of 'r' upper or lower case
        } else if(menuInput.equals("R") || menuInput.equals("r")) {
            System.out.print("\nPlease enter a value to remove: ");

            //Takes the user input here for the value to be removed
            inputValue = scan.nextInt();

            //Same thing as above, remove() in arraylist is only useful for the stated index not element specific,
            //which is why I use removeAll instances of Arrays.asList();
            numbers.removeAll(Arrays.asList(inputValue));

            //Instance variable calls the method remove() to rid of the input value
            //remove here also checks if the element even exists
            inst.remove(inputValue);
            System.out.println("\nIn-Order: ");

            //prints the in-order as asked
            inst.inOrder();
            System.out.println();

            //prompts the menu again for further manipulations to the tree
            menu();

        //tests for user-input for values of 'e' upper or lower case
        } else if(menuInput.equals("E") || menuInput.equals("e")) {
            System.out.println("\nExit!");

            //Clear cut way to exit cleanly from Java. No need to prompt the menu
            System.exit(0);

        } else {
            System.out.println("\nPlease re-enter your input, avoid whitespaces as well!");

            //prompts menu since typo was noticed
            menu();
        }
    }
 
}