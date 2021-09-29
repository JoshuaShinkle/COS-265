import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimumStack<Item extends Comparable> implements Iterable<Item> {
    public MinimumStack() {

    }

    // returns the number of items stored
    public int size() {
        return 0;
    }

    // returns true iff empty
    public boolean isEmpty() {
        return true;
    }

    // push item onto stack
    public void push(Item item) {

    }

    // pop and return the top item
    public Item pop() throws NoSuchElementException {
        return null;
    }

    // returns the minimum item in constant time
    public Item minimum() throws NoSuchElementException {
        return null;
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {

    }
}
