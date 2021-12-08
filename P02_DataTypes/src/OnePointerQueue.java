import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OnePointerQueue<Item> implements Iterable<Item> {
    // singly-linked list
    private static class Node<Item> {
        Item item = null;
        Node<Item> next = null;
        public Node(Item item) {this.item = item;}
        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    private int opcount = 0;
    private int size = 0;
    private Node<Item> last = null;
    public OnePointerQueue() { }

    // returns the number of items stored
    public int size() {
        return size;
    }

    // returns true iff empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // enqueue item to "back"
    public void enqueue(Item item) {
        opcount++;
        if (isEmpty()) {
            last = new Node<>(item);
        } else if (size() == 1) {
            last.next = new Node<>(item);
            Node<Item> tmp = new Node<>(last.item, last.next);
            last = last.next;
            last.next = tmp;
        } else {
            Node<Item> tmp = new Node<>(last.item, last.next);
            last.next = new Node<>(item);
            last = last.next;
            last.next = tmp.next;
        }
        size++;
    }

    // dequeue item from "front"
    public Item dequeue() throws NoSuchElementException {
        opcount++;
        if (isEmpty()) {
            throw new NoSuchElementException("dequeue called on empty queue\n");
        } else if (size()==1) {
            size--;
            return last.item;
        } else if (size()==2) {
            Node<Item> tmp = new Node<>(last.item, last.next);
            last.next = null;
            size--;
            return tmp.next.item;
        } else {
            Node<Item> tmp = new Node<>(last.item, last.next);
            last.next = last.next.next;
            size--;
            return tmp.next.item;
        }
    }

    // returns new Iterator<Item> that iterates over items
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int frozenOpCount = opcount;
            Node<Item> p = last;

            @Override
            public boolean hasNext() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified queue while iterating");
                }
                return p.next != null;
            }

            @Override
            public Item next() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified queue while iterating");
                }
                Item tmp = p.item;
                p = p.next;
                return tmp;
            }

            @Override
            public void remove() {}
        };
    }

    // perform unit testing here
    public static void main(String[] args) {
        OnePointerQueue<String> testString = new OnePointerQueue<>();
        assert testString.size()==0;
        assert testString.isEmpty();
        testString.enqueue("itemuno");
        assert testString.size()==1;
        assert !testString.isEmpty();
        testString.enqueue("itemdos");
        assert testString.size()==2;
        assert !testString.isEmpty();
        testString.enqueue("itemtres");
        assert testString.size()==3;
        assert !testString.isEmpty();
        String dequeuedString = testString.dequeue();
        StdOut.println(dequeuedString);
        dequeuedString = testString.dequeue();
        StdOut.println(dequeuedString);
        dequeuedString = testString.dequeue();
        StdOut.println(dequeuedString);
        assert testString.size()==0;
        assert testString.isEmpty();
//
//        // fails
//        dequeuedString = testString.dequeue();
        testString.enqueue("testuno");
        assert testString.size()==1;
        assert !testString.isEmpty();
        testString.enqueue("testdos");
        assert testString.size()==2;
        assert !testString.isEmpty();
        testString.enqueue("testtres");
        assert testString.size()==3;
        assert !testString.isEmpty();
        Iterator<String> iter = testString.iterator();
        StdOut.println("iterate:" + iter.next());
        StdOut.println("iterate:" + iter.hasNext());
//        testString.dequeue();
        StdOut.println("iterate:" + iter.next());
//        testString.enqueue("testcuatro");
        StdOut.println("iterate:" + iter.hasNext());
        StdOut.println("iterate:" + iter.next());
    }
}
