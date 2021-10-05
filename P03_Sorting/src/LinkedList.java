import java.util.Iterator;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node first = null;
    private int count = 0;

    private class Node {
        final Item item;    // cannot change item once it is set in constructor
        Node next;          // can change next, though

        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    public LinkedList() { }

    public LinkedList(Item[] fromList) {
        for(Item item : fromList) insert(item);
    }

    public void insert(Item item) {
        first = new Node(item, first);
        count++;
    }

    public Item remove() {
        Item item = first.item;
        first = first.next;
        count--;
        return item;
    }

    public boolean isEmpty() { return count == 0; }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    /***********************************************************************
     * Rearranges the linked list in ascending order, using the natural order
     * and mergesort.
     ***********************************************************************/
    
    public void sort() {
    }

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = {0.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
    }
}
