/**
 * Andrew Kim
 * 06.06.2018
 * CS 241-01
 *
 * Description: Testing the SortingAlgorithms.java class. Tests Quick, Merge, Insertion, Bubble, and Selection Sort
 *              will test regarding indexes in arrays of aobut 20,000,000 sizes in the largest and 10,000 in the shortest.
 */


public class SortingAlgorithmTest {

    public static void main(String[] args) {

        // instantiation of each type of sort.
        SortingAlgorithms bubble = new SortingAlgorithms();
        SortingAlgorithms selection = new SortingAlgorithms();
        SortingAlgorithms insertion = new SortingAlgorithms();
        SortingAlgorithms merge = new SortingAlgorithms();
        SortingAlgorithms quick = new SortingAlgorithms();

        // sets up values to create array size
        int tenThousand = 10000;
        int twentyThousand = 20000;
        int fiftyThousand = 50000;
        int hundredThousand = 100000;
        int threehundo = 300000;
        int mill = 1000000;
        int twentymill = 20000000;
        int twohundomill = 200000000;

        // initialize array
        int[] bubbleArray = new int[twentyThousand];
        int[] selectionArray = new int[fiftyThousand];
        int[] insertionArray = new int[hundredThousand];
        int[] mergeArray = new int[twentymill];
        int[] quickArray = new int[mill];


        // sort the array through a Bubble Sorting algorithm
        System.out.println("\n-----------------------------------\n");
        // randomize the array
        bubble.random(bubbleArray);
        bubble.bubbleSort(bubbleArray);
        // print array of newly sorted algorithm bubblesort
        bubble.bubblePrint(bubbleArray);

        // sort the array through a Selection Sorting algorithm
        System.out.println("\n-----------------------------------\n");
        // randomize the array
        selection.random(selectionArray);
        selection.selectionSort(selectionArray);
        // print array of newly sorted algorithm selection Sort
        selection.printArray(selectionArray);

        // sort the array through a Insertion Sorting algorithm
        System.out.println("\n-----------------------------------\n");
        // randomize the array
        insertion.random(insertionArray);
        insertion.insertionSort(insertionArray);
        // print array of newly sorted algorithm selection Sort
        insertion.printArray(insertionArray);

        // sort the array through a Merge Sorting algorithm
        System.out.println("\n-----------------------------------\n");
        // randomize the array
        merge.random(mergeArray);
        merge.mergeSort(mergeArray, 0, mergeArray.length-1);
        // print array of newly sorted algorithm selection Sort
        System.out.print("Merge Sort:    ");
        merge.printArray(mergeArray);

        // sort the array through a Quick Sorting algorithm
        System.out.println("\n-----------------------------------\n");
        // randomize the array
        quick.random(quickArray);
        quick.quickSort(quickArray, 0, quickArray.length-1);
        // print array of newly sorted algorithm selection Sort
        quick.printArray(quickArray);

    }
}
