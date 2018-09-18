public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ArrayBag() {

        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        }

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        boolean empty = false;

        if(numberOfEntries == 0) {
            empty = true;
        }
        return empty;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        boolean added = true;

        if(numberOfEntries >= bag.length) {
            added = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return added;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal.
     * was successful, or null.
     */
    public T remove() {
        T rem = null;
        int lastIndex = numberOfEntries-1;
        
        if(initialized) {
        	rem = bag[lastIndex];
	        bag[lastIndex] = null;
	        numberOfEntries -= 1;
        }
        

        return rem;
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        int loc = 0;
        boolean removed = false;

        for(int i = 0; i < bag.length; i++) {
            if(anEntry.equals(bag[i])) {
                loc = i;
                bag[loc] = null;
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        for(int i = 0; i < numberOfEntries; i++) {
            remove(bag[i]);
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for(int i = 0; i < numberOfEntries; i++) {
            if(bag[i].equals(anEntry)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        boolean contained = false;

        for(int i = 0; i < numberOfEntries; i++) {
            if(anEntry.equals(bag[i])) {
                contained = true;
            }
        }
        return contained;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        // Must be implimented
        T[] temp = (T[])new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++) {
            temp[i] = bag[i];
        }
        return temp;
    }
}
