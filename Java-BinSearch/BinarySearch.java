/**
 *      Name:           Andrew Kim
 *      Date:           04.25.2018
 *      Class:          CS-241-01
 *      Description:    A binary tree implementation that takes user input
 *                      to create an ordered binary tree. Additional features include
 *
 */

import java.util.*;
 
// use generics and implements the comparable class, for comparing two objects
public class BinarySearch<T extends Comparable<? super T>> {
 
    private BinaryNode root;

    // no-arg constructor to initialize the root of the tree, even though it is null
    public BinarySearch() {
        root = null;
    }

    // private inner binary node class for ease of use and initalization
    private class BinaryNode {
 
        private T data;
        private BinaryNode leftChild, rightChild;
 
        // one-arg constructor, for a binary node(just the leaf) with no concurrent immediate children
        public BinaryNode(T dataInp) {
            leftChild = rightChild = null;
            data = dataInp;
        }
 
    }
 
    /**
     * This method will add the desired node as long as it's not a duplicate
     * @param entry, the value to be added into the tree
     */
    public T add(T entry) {
        T temp = null;
 
        if(root == null) {
            //if a binary tree isn't even made, we'll make one now with the value of entry
            root = new BinaryNode(entry);
        } else {
            // calls the method addEntry, which holds 2 parameters, One of them is the root node
            // the other being the value of the input being passed
            temp = addEntry(root, entry);
        }
        return temp;
    }
 
    //private method addEntry from the add() method, returns T result for the value that was added
    private T addEntry(BinaryNode root, T newEntry) {
        T result = null;

        //comparison here will be 3 possible values, 0, -1, 1. 0 means that the newEntry value is equal
        //to the root node data. -1 means that the value will be less than the root data which lets us know
        //that it will be to the left children/subtree. A value of 1 tells us that the value will be greater
        //than the root telling us it needs to go to the right children/subtree.
        int comparison = newEntry.compareTo(root.data);

        if(comparison > 0) {

            //if the right children's root exist
            if(root.rightChild != null) {
                //then recursion happens here, where the rightChild will keep being pushed down upon
                result = addEntry(root.rightChild, newEntry);
            } else {
                // if the root's right children is null, where we hit the recursion limit and the end 
                // of the line. Then we create the new BinaryNode entry with the node connection and value
                // of newEntry.
                root.rightChild = (new BinaryNode(newEntry));
            }

        // if the value that we're trying to add is less than the root value
        } else if(comparison < 0) {
            
            if(root.leftChild != null) {
                // recursion where we keep pushing to the end of the left child until we hit a null value
                // keep passing the newEntry value while we check for the end.
                result = addEntry(root.leftChild, newEntry);
            } else {
                // once we hit the end, create the node connection and pass the value to its correct spot
                root.leftChild = (new BinaryNode(newEntry));
                
            }

        } else {

            // when comparison == 0
            System.out.println(newEntry + " already exists. Duplicates are not allowed.");
            // return this because we still need to satisfy the T return value
            return root.data;
        }
 
        return result;
    }

    //this method will remove the desired node as long as it exists
    public T remove(T newEntry) {
        //creates a temporary binary node and passes it to the recursive method removeEntry
        //takes 2 parameters, 1 is the base (root), the other is the value that is trying to be
        //removed
        BinaryNode result = removeEntry(root, newEntry);

        //change the value so that root is now easier to maintain and search and compensate for the removal
        //after the recursion
        root = result;

        //satisfy the return type
        return null;
    }

    //private recursive method that returns of type BinaryNode
    private BinaryNode removeEntry(BinaryNode node, T newEntry) {

        //if the current node, starting with the root, does not exist anymore
        if(node == null) {
            // then the recursion is done the value never existed.
            System.out.println("Node does not exist.");
            return node;
        }

        //same comparison as the add method. 3 possible values, 0, -1, 1. -1 tells us its in the left subtree
        //1 tells us its in the right subtree, 0 tells us we hit the location.
        int comparison = newEntry.compareTo(node.data);

        //if found the node for removing
        if(comparison == 0) {

            //separate method to actually remove the node from the root
            node = removeFromRoot(node);

        //else keep comparing and recursing through the tree till its found, the value is still to the left
        //of the subtree.
        } else if(comparison < 0) {
            BinaryNode left = node.leftChild;
            node.leftChild = removeEntry(left, newEntry);
        //else keep comparing and recursing through the tree till its found, the value is still to the right
        //of the subtree.
        } else if(comparison > 0) {
            BinaryNode right = node.rightChild;
            node.rightChild = removeEntry(right, newEntry);

        } else {
            //Doesn't exist, traversed the whole tree.
            System.out.println("Node does not exist.");
        }

        //satisfy the return type
        return node;
    }

    //public method for finding largest value, takes parameter node usually the root
    public BinaryNode findLargest(BinaryNode node) {
        //only check rightChild because for large values unless specifically a one leaf node tree
        //the greatest possible value has to be on the right side. Recurse through.
        if(node.rightChild != null) {
            //recurse through the right side until we reach the last leaf node on the right subtree
            node = findLargest(node.rightChild);
        } 
        //is the leaf node or the return condition has been satisfied for the recursion
        return node;
    }

    //removes the largest node utilzing the method from findLargest
    public BinaryNode removeLargest(BinaryNode node) {
        //if we haven't gone to the last leaf node to the right subtree
        if(node.rightChild != null) {
            //recurse through the rightChildren until we reach the end
            BinaryNode right = node.rightChild;
            right = removeLargest(right);
            //while recursing keep updating the value of rightChildren to increment through
            node.rightChild = right;
        } else {
            // its not on the right side, so lets check here
            node = node.leftChild;
        }

        //satisfy the return condition and pass the value to other methods such as removeFromRoot
        return node;
    }

    //method to remove root node, passed from removeEntry(), this prerequisite here
    //is that comparison has to equal 0
    public BinaryNode removeFromRoot(BinaryNode node) {
        //if there are 2 children with values
        if(node.rightChild != null && node.leftChild != null) {
            BinaryNode left = node.leftChild;
            //temp binarynode made to find the largest value in the tree
            BinaryNode largest = findLargest(left);
            //change the current node's value, usually starting from root, with the largest value in the tree
            node.data = largest.data;
            //remove the left subtree's child's largest value 
            node.leftChild = removeLargest(left);
        //if there is 1 children and it's on the right side
        } else if(node.rightChild != null) {
            //change the node value to the right children, comparision == 0
            node = node.rightChild;
        //if there is 1 children and it's on the left side
        } else {
            //change the node value to the far left one
            node = node.leftChild;
        }

        return node;
    }
 
    /**
     * Checks whether any duplicates exist in the array. There could've been faster implementation methods
     * either utilizing hashsets or bitsets, but this method isn't expecting extremely large inputs thus the
     * worst case is O(n^2), but at a small scale.
     *
     * @param arrayList, the integer arraylist to be tested whether duplicates exist or not
     * @return false if the array contained no duplicates, true otherwise
     */
    public boolean checkDuplicates(ArrayList<T> array) {
        boolean duplicates = false;
 
        for(int i = 0; i < array.size(); i++) {
            //one above the regular one since no point in comparing the same index
            for(int j = i+1; j < array.size(); j++) {
                //if the two indexes are different, but the values within the arraylist are the same
                if(i != j && array.get(i) == array.get(j))
                    //change the boolean flag
                    duplicates = true;
            }
        }
        return duplicates;
    }


    public void preOrder() {
        preOrderTree(root);
    }

    public void preOrderTree(BinaryNode node) {
        //if the node is not empty
        if(node != null) {
            //print out the current node's data
            System.out.print(node.data + " ");
            //recurse through starting with the left child until null
            preOrderTree(node.leftChild);
            //then recurse through the right until null is hit
            preOrderTree(node.rightChild);
        }
    }
 
    public void inOrder() {
        inOrderTree(root);
    }

    public void inOrderTree(BinaryNode node) {
        if(node != null) {
            //recurse through the left child until null
            inOrderTree(node.leftChild);
            //print out the current node's data after the hit
            System.out.print(node.data + " ");
            //recurse through the right child until null, reverse through
            inOrderTree(node.rightChild);
        }
    }
 
    public void postOrder() {
        postOrderTree(root);
    }

    public void postOrderTree(BinaryNode node) {
        if(node != null) {
            //recurse through the left until null
            postOrderTree(node.leftChild);
            //recurse through the right until null
            postOrderTree(node.rightChild);
            //print out the current data after the recursive twining
            System.out.print(node.data + " ");
        }
    }
 
}