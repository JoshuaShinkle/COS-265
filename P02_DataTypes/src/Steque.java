import org.w3c.dom.traversal.NodeIterator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<Item> implements Iterable<Item> {
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
    private Node<Item> first = null;
    private Node<Item> last = null;

    public Steque() { }

    // returns the number of items stored
    public int size() {
        return size;
    }

    // returns true iff steque is empty
    public boolean isEmpty() {
        return size==0;
    }

    // enqueues item to bottom of steque
    public void enqueue(Item item) {
        opcount++;
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        } else {
            last.next = new Node<>(item);
            last = last.next;
        }
        size++;
    }

    // pushes item to top of steque
    public void push(Item item) {
        opcount++;
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        } else {
            Node<Item> tmp = new Node<>(item);
            tmp.next = first;
            first = tmp;
        }
        size++;
    }

    // pops and returns top item
    public Item pop() throws NoSuchElementException {
        opcount++;
        if (isEmpty()) {
            throw new NoSuchElementException("pop called on empty steque\n");
        }
        Item tmp = first.item;
        first = first.next;
        size--;
        return tmp;
    }

    // returns new Iterator<Item> that iterates over items in steque
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int frozenOpCount = opcount;
            Node<Item> p = first;

            @Override
            public boolean hasNext() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified stegue while iterating");
                }
                return p.next != null;
            }

            @Override
            public Item next() {
                if (frozenOpCount != opcount) {
                    throw new ConcurrentModificationException("modified stegue while iterating");
                }
                Item tmp = p.next.item;
                p = p.next;
                return tmp;
            }

            @Override
            public void remove() {}
        };
    }

    // perform unit testing here
    public static void main(String[] args) throws NoSuchElementException {
        Steque<String> testString = new Steque<>();
        assert testString.size()==0;
        assert testString.isEmpty();
        testString.enqueue("itemuno");
        assert testString.size()==1;
        assert !testString.isEmpty();
        testString.push("pushThis");
        assert testString.size()==2;
        assert !testString.isEmpty();
        testString.enqueue("itemtres");
        assert testString.size()==3;
        assert !testString.isEmpty();
        String poppedString = testString.pop();
        StdOut.println(poppedString);
        poppedString = testString.pop();
        StdOut.println(poppedString);
        poppedString = testString.pop();
        StdOut.println(poppedString);
        assert testString.size()==0;
        assert testString.isEmpty();
        testString.push("push1This");
        assert testString.size()==1;
        assert !testString.isEmpty();
        testString.push("push2This");
        assert testString.size()==2;
        assert !testString.isEmpty();
        poppedString = testString.pop();
        StdOut.println(poppedString);
        poppedString = testString.pop();
        StdOut.println(poppedString);
        // fails
//        poppedString = testString.pop();
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
//        testString.pop();
        StdOut.println("iterate:" + iter.next());
//        testString.enqueue("testcuatro");
//        testString.push("testcuatro");
        StdOut.println("iterate:" + iter.hasNext());
//        StdOut.println("iterate:" + iter.next());
    }
}