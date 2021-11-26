package structures;

import java.util.ArrayList;

/**
 * A Queue class where the first item to be added is the first item to be removed.
 *
 * @param <T> Type of element to be stored in the Queue
 * @author wpinrui
 */
public class Queue<T> {
    private final ArrayList<T> queue = new ArrayList<>();

    /**
     * Empty constructor that instantiates an empty queue.
     */
    public Queue() {
    }

    /**
     * Constructor that takes in a variable number of elements used to initialise the queue.
     *
     * @param args Elements to be added to the queue in order
     */
    @SafeVarargs
    public Queue(T... args) {
        for (T item : args) {
            enqueue(item);
        }
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return length() == 0;
    }

    /**
     * Add an item to the end of the queue.
     *
     * @param item Item to be inserted
     */
    public void enqueue(T item) {
        queue.add(item);
    }

    /**
     * Removes and returns the item at the front of the queue. Throws an Exception if the queue is empty.
     *
     * @return Item that was added least recently
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return queue.remove(0);
    }

    /**
     * Returns the number of items in the queue.
     *
     * @return Number of items in the queue
     */
    public int length() {
        return queue.size();
    }

    /**
     * Returns the element at the front of the queue without removing it. Throws an Exception if the queue is empty.
     *
     * @return Element that was least recently added to the queue
     */
    public T peek() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return queue.get(0);
    }

    /**
     * Checks if a given object is a queue with the same elements as this queue.
     *
     * @param o The object to be compared to this queue
     * @return True if the given object is a queue with the same elements as this queue.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Queue)) {
            return false;
        }
        return queue.equals(((Queue<?>) o).queue);
    }

    /**
     * Clears all elements from the Queue.
     */
    public void clear() {
        queue.clear();
    }

    /**
     * Returns a String representation of the Queue.
     *
     * @return A String representation of the Queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder items = new StringBuilder();
        for (T item : queue) {
            items.append(String.format("%s, ", item));
        }
        return String.format("[%s]", items.substring(0, items.length() - 2));
    }
}
