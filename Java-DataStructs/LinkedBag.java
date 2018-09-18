public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    // LinkedBag() default constructor.
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // inner class needed, with 2 arg constructors
    private class Node {
            private T data; 
            private Node next;

            private Node(T dataPortion) {
                this(dataPortion, null);
            }

            private Node(T dataPortion, Node nextNode) {
                data = dataPortion;
                next = nextNode;
            }
    }

    /** Gets the current number of entries in this bag.
     @return  The integer number of entries currently in the bag. */
    public int getCurrentSize(){
        return numberOfEntries;
    }

    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. */
    public boolean isEmpty(){
        return firstNode == null;
    }

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or false if not. */
    public boolean add(T newEntry){
        boolean added = true;
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        // boolean status weird here
        return added;
    }

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal.
     was successful, or null. */
    public T remove(){
        T result = null;

        // incrementor here
        if(firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }

        return result;
    }

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry){
        boolean removal = false;
        Node temp = firstNode;

        while(temp != null) {
            if(anEntry.equals(temp.data)) {
                break;
            } else {
                temp = temp.next;
            }
        }

        if(temp != null) {
            temp.data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            removal = true;
        }
        return removal;
    }

    /** Removes all entries from this bag. */
    public void clear(){
        while(!isEmpty()) {
            remove();
        }
    }

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry){
        int freq = 0;
        Node currentN = firstNode;

        for(int i = 0; i < numberOfEntries && (currentN != null); i++) {
            if(anEntry.equals(currentN.data)) {
                freq++;

            }
            currentN = currentN.next;
        }

        return freq;
    }

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)) {
            if(anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in the bag.
     Note: If the bag is empty, the returned array is empty. */
    public T[] toArray(){

        T[] result = (T[])new Object[numberOfEntries];
        Node currentNode = firstNode;

        for(int i = 0; i < numberOfEntries; i++) {
            if(currentNode != null) {
                result[i] = currentNode.data;
                currentNode = currentNode.next;
            }
        }
        return result;
    }
}
