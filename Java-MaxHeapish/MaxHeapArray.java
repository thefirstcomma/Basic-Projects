/**
* Andrew Kim
* CS 241 Project 2
* 05.22.2018
*
* Write a detailed report, record average number of swaps for both methods (over 5 sets) 
* in case of option 1 and analyze heap implementation efficiency theoretically and experimentally. 
* In case of option 2, enter some random number of your choice and output the number of swaps 
* and level order traversal of the heap.
*/

import java.util.*;

public class MaxHeapArray{

    private static int[] heap;
    private static int[] emptyHeap = new int[101];
    private static int[] counters = new int[5];
    private static int[] addArray = new int[5];
    private static int swapCounter, addCounter, lastIndex = 0;
    private static String input;
    private static Scanner scan = new Scanner(System.in);

    /**
     * A menu prompt that starts the program and validates user input is either
     * 1 or 2, as a string. if user enters 1, moves to function fiveRepeats() which will initiate
     * 5 sets of 100 sized randomly generated arrays and heap sort in appropriate function.
     * Input option 2, will further prompt user input for more integers to put into an array
     */
    private static void menu() {
        // simple prompt that encourages user to enter 1 or 2
        System.out.println("(1.) 5 sets of 100 random positive integers in range 1 to 1000." +
                "(No duplicates are allowed).\n(2) Random positive integers entered by user (No" +
                "duplicates are allowed)\nEnter (1) or (2) please: ");
        // user input for which style of inputs they want, randomly generated or user inpputed
        input = scan.nextLine();

        // case condition if user does not input 1 or 2
        if(!input.equals("1") && !input.equals("2")) {
            System.out.println("Enter a valid number.");
            // recursively calls itself but no objects were called thus recursive call will behave properly
            menu();

        } else if(input.equals("1")) {
            System.out.println("5 sets of 100 random positive integers chosen.");
            fiveRepeats(); // fiveRepeats is a method that will generate 100 random values, count their
                            // respective swaps and average it up.

        } else {
            // user entered 2, heap will now have to get manual inputs and check for duplicates
            System.out.println("User input, positive integers only, no duplicates");
            // this calls the function arrayInput which has its own checkDuplicates in there, if duplicates does exist
            // the function recalls itself, and returns value of int[] which is assigned to the array heap.
            heap = arrayInput();
        }

    }

    /**
     * An iterator over the randomly generated heap. Calls function random() 
     * 5 times and sets the number of swaps
     * sequentially and optimally into its respective array for addArray and counters. 
     */
    private static void fiveRepeats() {

        // for loop, simply repeats 5 times
        for(int i = 0; i < 5; i++) {
            // creates a new object of size 100
            heap = new int[100];
            // calls the function random() which randomly generates 100 integers and sets the value of heap into it.
            heap = random();

            for(int index = 1; index < heap.length; index++) {
                // index starts at 1 because emptyHeap is sized [101]
                add(heap[index-1]);
            }
            // calls the function heapSort at the bottom, which will use reheap() to organize the randomly generated array.
            heapSort();

            for(int j = heap.length-1; j >= 0; j--) {
                //just prints out the values in the heap
                System.out.print(heap[j] + " ");
            }

            // set the index of the array counters with the counter and reset
            addArray[i] = addCounter;
            // get the average here, and compensate for the division from the swapCounter.
            counters[i] = swapCounter*2;

            // reset all the counters for the 5 sets
            swapCounter = 0;
            lastIndex = 0;
            addCounter = 0;
            System.out.println("\n----------------------------------------------------------------------------------");
        }


    }

    /**
     * A method that randomly generates 100 positive values. If any duplicates are detected
     * we will discard the array and restart until a 100 indexed array contains no duplicates
     * @return an int[] array that holds the 100 random, non duplicated, array.
     */
    private static int[] random(){
        // random object to generate random values
        Random rand = new Random();

        // create a temporary array sized 100 
        int[] array = new int[100];

        for(int i = 0; i < array.length; i++) {
            // generates a random integer from 1-1000
            int randomValue = rand.nextInt(1000) + 1;
            // assigns the value to the index location
            array[i] = randomValue;
        }

        // checks for duplicates, O(n^2) but simple and easily readible
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                // if equaled or duplicate detected redo
                if(array[i] == array[j]) {
                    // if detected here is the redo assigned
                    array = random();
                }
            }
        }

        // returns the given array if successful
        return array;
    }

    /**
     * Gathers the manual user input, from start() when the user entered option 2.
     * Will take user input and create a String array from the gathered input, will then
     * parse to integer and return said array.
     * @return an int[] array that holds the user inputted, non duplicated, positive array.
     */
    private static int[] arrayInput() {
        System.out.println("Enter numbers followed by whitespaces");
        String temp = scan.nextLine();

        // splits the string temp wherever one whitespace is detected and creates an array with separated values
        String[] tempArray = temp.split(" ");
        // arr is the returned array, sized tempArray length
        int[] arr = new int[tempArray.length];

        for(int i = 0; i < arr.length; i++) {
            // parse from Integer to String
            arr[i] = Integer.parseInt(tempArray[i]);
            // add to emptyHeap as well
            add(Integer.parseInt(tempArray[i]));
        }

        // checks for duplicates
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++) {
                // if equaled or duplicate detected redo
                if (arr[i] == arr[j] || arr[i] < 0) {
                    System.out.println("Duplicate detected or Negative Input! RE-Enter");
                    // self call here in a somewhat recursive fashion, only if duplicate or negative is detected.
                    arr = arrayInput();
                }
            }
        }

        return arr;
    }

    /**
     * Adds an entry into an initially empty array. Sequentially adding it one at a time and counting all the swaps
     * @param newEntry The integer to be added incrementally to an initially empty or complete tree, array.
     */
    private static void add(int newEntry) {
        // new index is going to be the next available slot, so the last possible index + 1
        int newIndex = lastIndex+1;
        // parent index in a complete or full array is always current / 2. integer divide only.
        int parentIndex = newIndex / 2;

        // checks if parentIndex is non-negative and that the inputted value is greater than it's parent
        while (parentIndex > 0 && newEntry > emptyHeap[parentIndex]) {
            // if it is greater than we swap it here
            emptyHeap[newIndex] = emptyHeap[parentIndex];
            // then change the respective values 
            newIndex = parentIndex;
            // change the respective parent index due to the swap
            parentIndex = newIndex / 2;
            // adds an increment
            addCounter++;
        }

        // assigns value of newEntry to the array index that is available
        emptyHeap[newIndex] = newEntry;
        // increments
        lastIndex++;

    }

    /**
     * Recursively organizes and sorts the given array heap, does most of the operation in O(n) time however
     * can sometimes average around. Checks left, right and parent. Doesn't necessarily build the heap itself, but
     * checks if leftChild is less than the heapArray size and if the index of the heap's left chjild is greater than
     * the heap's index. If so sets largest and does it recursively in a fast rate.
     * O(n*log(n)), depending on how the array is built and how the input is taken.
     * @param index,  the first location to use as reference, int index
     * @param heapSize,  The length of the heap, usually user inputted or 100+1
     */
    private static void reheap(int index, int heapSize) {

        // left side of the heap is going to be the current index * 2, (root)
        int left = index*2;
        // right side is going to be the same index * 2 + 1,
        int right = left + 1;
        int largest;

        // checks if left is going to be less than the heap array length or equal to it
        // and checks if the left side of the index of heap is greater than the heap index -1
        if(left <= heapSize && heap[left - 1] > heap[index - 1]) {
            // if it is, the larger value is found in the left side and we assign it respectively
            largest = left;
        } else {
            // if heap index is greater just merely assign it, the parent node is the greater than the left kid
            largest = index;
        }

        // checks if right is going to be less than the heap array length or equal to it
        // and checks if the right side of the index of heap is greater than the heap index -1
        if(right <= heapSize && heap[right-1] > heap[largest-1]) {
            // assigns it if it notices that the parent is less than the right kid
            largest = right;
        }

        if(largest != index) {
            // if the largest value was under the parent node, perform the swap
            swap(index-1, largest-1);
            // recursively call it this time change the index to the largest value to keep swapping it up.
            reheap(largest, heapSize);
        }
    }

    /**
     * Recursively organizes and sorts the given array heap, does most of the operation in O(n) time however
     * can sometimes average around. Checks left, right and parent. Doesn't necessarily build the heap itself, but
     * checks if leftChild is less than the heapArray size and if the index of the heap's left chjild is greater than
     * the heap's index. If so sets largest and does it recursively in a fast rate.
     * O(n*log(n)), depending on how the array is built and how the input is taken.
     * @param index,  the first location to use as reference, int index
     * @param heapSize,  The length of the heap, usually user inputted or 100+1
     * @param counter, used to differentiate the operator overload method between regular reheap(int index, int heapSize)
     */
    private static void reheap(int index, int heapSize, int counter) {

        // left side of the heap is going to be the current index * 2, (root)
        int left = index*2;
        // right side is going to be the same index * 2 + 1,
        int right = left + 1;
        int largest;

        // checks if left is going to be less than the heap array length or equal to it
        // and checks if the left side of the index of heap is greater than the heap index -1
        if(left <= heapSize && heap[left - 1] > heap[index - 1]) {
            // if it is, the larger value is found in the left side and we assign it respectively
            largest = left;
        } else {
            // if heap index is greater just merely assign it, the parent node is the greater than the left kid
            largest = index;
        }

        // checks if right is going to be less than the heap array length or equal to it
        // and checks if the right side of the index of heap is greater than the heap index -1
        if(right <= heapSize && heap[right-1] > heap[largest-1]) {
            // assigns it if it notices that the parent is less than the right kid
            largest = right;
        }

        if(largest != index) {
            // if the largest value was under the parent node, perform the swap
            swap(index-1, largest-1);
            // recursively call it this time change the index to the largest value to keep swapping it up.
            reheap(largest, heapSize);
            // increase the counter by 1
            swapCounter++;
        }
    }

    /**
     * A simple swap algorithm that swaps it according to the first two index.
     * @param first,  The first integer to move
     * @param second,  The second integer to move and swap the first with
     */
    private static void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;

    }

    /**
     * Accept the given visitor to visit all objects contained.
     * 
     */
    private static void heapSort() {
        int length = heap.length;
        int counter = 0;

        for(int i = length/2; i > 0; i--) {
            reheap(i, length, counter);
        }

        for(int i = length - 1; i >= 0; i--) {
            swap(0, i);
            reheap(1, i);
        }
    }


    // main method counts, prints, initiates and prompts the array and menu
    public static void main(String[] args) {

        //prompt for user-input or random generated
        menu();
        //to compensate for the method that reverse increments it through and thus skips a step.
        swapCounter++;

        if(input.equals("2")) {
            heapSort();

            for(int i = heap.length-1; i >= 0; i--) {
                // just prints out the values in the heap in reverse incremental order instead of the common
                // tree order, this is just to show that the heap sort and add method did work
                // alternatively one can use for(int i = heap.length/2 -1; i >= 0; i--) to print in the addressed tree
                System.out.print(heap[i] + " ");
            }


            // prints out counters
            System.out.println("\nReHeap Counter: " + swapCounter);
            System.out.println("Sequential Counter: " + addCounter);

        } else if(input.equals("1")) { // if the user wanted random numbers generated

            // temporary placeholder averages
            double addAverage = 0;
            double average = 0;

            for(int i = 0; i < 5; i++) {
                // print out the counters of the 5 sets of 100 sized arrays
                System.out.println("ReHeap Counters: " + counters[i] + " ");
                System.out.println("Sequential Counter: " + addArray[i] + " ");
                // average = average + array[i]
                addAverage += addArray[i];
                average += counters[i];
            }
            // average total of swap from the combined total
            average /= 5;
            addAverage /= 5;

            // prints out the average, really simple
            System.out.println("ReHeap Average: " + average);
            System.out.println("Sequential Average: " + addAverage);
        }

    }

}
