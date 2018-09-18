/**
 * Andrew Kim
 * 06.06.2018
 * CS 241-01
 *
 * Description: A bunch of sorting algorithms that are common practices and of essential uses.
 *
 */

import java.util.*;

public class SortingAlgorithms {

    /**
     * Generates random values of 1 - 100,000 to the entire array, which was initially empty.
     *
     * @param arr, the integer array to be taken to store random values
     */
    public void random(int[] arr) {
        // rand instantiation created for Random class used later for random generations
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++) {
            // 1 - 100,000 randomly generated, repeats allowed
            arr[i] = rand.nextInt(100000) + 1;
        }
    }

    /**
     * Sorts, the entire array by repeatedly swapping indexes that are next to each other in the case of 
     * a wrong order.
     *
     * @param arr, the integer array to be sorted
     */
    public void bubbleSort(int[] arr) {
        System.out.print("Bubble Sort:    ");
        // boolean to end for loops.
        boolean swap = false;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length; j++) {
                // if the current index is greater than the previous index, swap
                if(arr[j] > arr[j-1]) {
                    // swap algorithm
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    // a swap occured
                    swap = true;
                }
            }

            // if no swaps were made in this run, then stop wasting memory
            if(!swap) {
                break;
            }
            // after the completion of a loop flip variable swap to false, so that if
            // swap isn't true throughout one loop, then it should stop doing for loops.
            swap = false;
        }
    }

    /**
     * Selection sort, goes through entire array and looks for the shortest value. Then places it at
     * the beginning. Utilizes a swap technique.
     *
     * @param arr, the integer array to be sorted
     */
    public void selectionSort(int[] arr) {
        System.out.print("Selection Sort:    ");

        // saves one increment here by stopping at arr.length-1
        for(int i = 0; i < arr.length-1; i++) {
            // temp ref int created
            int index = i;

            // j continues off where i is, and stops till the end of the array
            for(int j = i+1; j < arr.length; j++) {
                // find the min value in array, store value of the index
                if(arr[j] < arr[index])
                    index = j;
            }

            // a simple swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }


    /**
     * Similar to selection sort, Insertion sort will only increment through the array once, no
     * double for-loop is needed and reverses back its path until it can place the correct value 
     * at the correct index.
     *
     * @param arr, the integer array to be sorted
     */
    public void insertionSort(int[] arr) {
        System.out.print("Insertion Sort:    ");

        // start at index 1, go through entire array
        for(int i = 1; i < arr.length; i++) {
            // store the value in a temp
            int temp = arr[i];
            // j will be used as the previous index of where we're currently at.
            int j = i-1;

            // only performs the loop if j hasn't gone past the first index and if prev > curr
            while(j >= 0 && arr[j] > temp) {
                // if prev index is greater than current index, keep swapping 
                arr[j+1] = arr[j];
                // push all values to the right by 1 index location.
                j--;
            }

            // store the new value
            arr[j+1] = temp;
        }
    }


    /**
     * Merge sort is efficient, utilizes recursion and thus a private method will be made. Divides
     * and conquers in halfs of the array until we reach down to length/2 amount of tries.
     *
     * @param right, the very last index of the array, or the -1th index
     * @param left, the very first index of the array
     * @param arr, the integer array to be sorted
     */
    public void mergeSort(int[] arr, int left, int right) {

        // until the half point moment is reached
        if(left < right) {
            // middle is commonly defined here. integer division is fine
            int middle = (left + right) / 2;
            // recursively call the method from 0 - middle
            mergeSort(arr, left, middle);
            // recursively start the method from middle - end
            mergeSort(arr, middle+1, right);
            // calls a separate function that merges the values
            merge(arr, left, middle, right);
        }
    }

    /**
     * Performs the correct sorting of the array and changes the respective value of arr from
     * mergeSort based upon two subarray comparisons.
     *
     * @param high, the right side or the very last index of where we want to start
     * @param low, the left side or the very first index of where we want to start
     * @param middle, the middle'th index used as a common reference.
     * @param arr, the integer array to be organized and split.
     */
    private void merge(int[] arr, int left, int middle, int right) {
        // sizes of two temp arrays that are going to be used to merge, this is the left end starting index.
        int index_one = middle - left + 1;
        // this is the right end starting index
        int index_two = right - middle;

        // temporary subarray of first half of array, arr
        int first[] = new int[index_one];
        // temporary subarray of second half of array, arr
        int second[] = new int[index_two];

        // first loop will go from 0 - middleth index + 1
        for(int i = 0; i < index_one; i++) {
            // assign value from the recursive parameter and specifically offset by left and i 
            first[i] = arr[left + i];
        }

        // second loop will go from middleth index - arr.length 
        for(int j = 0; j < index_two; j++) {
            // assign value from the recursive parameter and specifically offset by middle and j
            second[j] = arr[middle + 1 + j];
        }

        // index and temporary value holder assigned here
        int i = 0, j = 0;
        int l = left;

        // condition of loop only if first two index are less than their respective halfway reference
        while(i < index_one && j < index_two) {
            // checks if the value in the first array is less than the value in the second array, offset by middleth index
            if(first[i] <= second[j]) {
                // change value if it is
                arr[l] = first[i];
                i++;
            } else {
                // change value if it isn't
                arr[l] = second[j];
                j++;
            }
            // increment the reference left side index counter
            l++;
        }

        // for first half assigns 
        while(i < index_one) {
            // change the values of arr by the offset in first
            arr[l] = first[i];
            i++;
            // increment the reference left side index counter
            l++;
        }

        while(j < index_two) {
            // change the values of arr by the offset in second
            arr[l] = second[j];
            j++;
            // increment the reference left side index counter
            l++;
        }
    }

    /**
     * Sorting algorithm highly reliant on its pivot and then moves values around the chosen pivot.
     * Highly dependent on the pivot chosen and will significantly alter the time complexity.
     *
     * @param high, right ending side of the array, typically the last index at the beginning.
     * @param low, left beginning side of the array, typically the 0th index at the beginning.
     * @param arr, the integer array to be printed, sorted
     */
    public void quickSort(int[] arr, int low, int high) {
        // until the half point moment is reached
        if(low < high) {
            // get the return index from the method call pivot() whilch will return the given pivot point.
            int sec = pivot(arr, low, high);

            // recursively calls the method quickSort but from the perspective of index low to pivot
            quickSort(arr, low, sec-1);
            // recursively calls the other half from index pivot to high
            quickSort(arr, sec+1, high);
        }
    }

    /**
     * For this method will put values of the array in its correct position and place all smaller values before
     * the chosen pivot, while placing all the greater values in front of it.
     *
     * @param high, the end of the arr that is needed to check, arr-1 first
     * @param low, the first index of the arr that is being passed
     * @param arr, the integer array to be printed, sorted
     */
    public int pivot(int[] arr, int low, int high) {
        // start with high value
        int pivot = arr[high];
        // first index is going to be the 0th position, so -1 is the initial value
        int index = (low-1);

        for(int i = low; i < high; i++) {
            // check if array low element is less than array high element
            if(arr[i] <= pivot) {
                index++;
                // perform the swap function if it is less than the pivot point
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        // performs a swap between arr[high] and arr[i+1]
        int temp = arr[index+1];
        arr[index+1] = arr[high];
        arr[high] = temp;

        // add by 1 for array index compensation
        return index + 1;

    }

    /**
     * Normal print statement that increments through entire array printing.
     *
     * @param arr, the integer array to be printed, already sorted
     */
    public void printArray(int[] arr) {
        // simple for loop
        for(int i = 0; i < arr.length; i++) {
            // printing out the array at index spot [i] with whitespaces in between
            System.out.print(arr[i] + " ");

        }
    }

    /**
     * A simple reverse print, only used in the case of bubbleSort.
     *
     * @param arr, the integer array to be printed, already sorted
     */
    public void bubblePrint(int[] arr) {
        // reverse for-loop since array is reverse sorted.
        for(int i = arr.length-1; i > -1; i--) {
            System.out.print(arr[i] + " ");
        }
    }

}