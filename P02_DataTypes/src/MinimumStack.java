import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimumStack<Item extends Comparable> implements Iterable<Item> {

    private static class Node<Item> {
        private Item item = null;
        private Node<Item> next = null;
        private Item minimumItem = null;
        public Node(Item item) {this.item = item;}
        public Node(Item item, Node<Item> next, Item minimumItem) {
            this.item = item;
            this.next = next;
            this.minimumItem = minimumItem;
        }
    }

    private int opcount = 0;
    private int size = 0;
    private Node<Item> first = null;

    public MinimumStack() { }

    // returns the number of items stored
    public int size() {
        return size;
    }

    // returns true iff empty
    public boolean isEmpty() {
        return size()==0;
    }

    // push item onto stack
    public void push(Item item) {
        opcount++;
        if (isEmpty()) {
            first = new Node<>(item);
            first.minimumItem = item;
            size++;
        } else {
            Node<Item> oldfirst = first;
            first = new Node<>(item, oldfirst, oldfirst.minimumItem);
            size++;
            if (oldfirst.minimumItem.compareTo(item) > 0) {
                first.minimumItem = item;
            }
        }
    }

    // pop and return the top item
    public Item pop() throws NoSuchElementException {
        opcount++;
        if (isEmpty()) throw new NoSuchElementException("pop called on empty stack");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    // returns the minimum item in constant time
    public Item minimum() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("minimum called on empty stack\n");
        }
        return first.minimumItem;
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int frozenOpCount = opcount;
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified stack while iterating");
                }
                return current != null;
            }

            @Override
            public Item next() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified stack while iterating");
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {}
        };
    }

    public static void main(String[] args) {
        MinimumStack<Integer> testInt = new MinimumStack<>();
        Iterator<Integer> iter = testInt.iterator();
        assert testInt.isEmpty();
        assert testInt.size() == 0;
//        testInt.minimum();
        assert !iter.hasNext();
//        iter.next();
//        testInt.pop();
        testInt.push(5);
        assert testInt.size() == 1;
        assert !testInt.isEmpty();
        StdOut.println(testInt.minimum());
//        iter.hasNext();
//        iter.next();
        testInt.push(6);
        StdOut.println(testInt.minimum());
        assert testInt.size() == 2;
        assert !testInt.isEmpty();
        testInt.push(4);
        StdOut.println(testInt.minimum());
        assert testInt.size() == 3;
        assert !testInt.isEmpty();
        testInt.push(3);
        StdOut.println(testInt.minimum());
        assert testInt.size() == 4;
        assert !testInt.isEmpty();
        testInt.push(2);
        StdOut.println(testInt.minimum());
        assert testInt.size() == 5;
        assert !testInt.isEmpty();
        Iterator<Integer> iter2 = testInt.iterator();
        assert iter2.hasNext();
        StdOut.println("iter " + iter2.next());
        StdOut.println("iter " + iter2.next());
        StdOut.println("iter " + iter2.next());
        StdOut.println("iter " + iter2.next());
        testInt.pop();
        StdOut.println(testInt.minimum());
        assert testInt.size() == 4;
        assert !testInt.isEmpty();
        testInt.pop();
        StdOut.println(testInt.minimum());
        assert testInt.size() == 3;
        assert !testInt.isEmpty();
        testInt.pop();
        StdOut.println(testInt.minimum());
        assert testInt.size() == 2;
        assert !testInt.isEmpty();
    }
}
