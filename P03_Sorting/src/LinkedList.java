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
        first = sort(first, count);
    }

    private Node sort(Node head, int len) {
        if (len <= 1) return head;
        Node mid = head;
        for (int i=0; i<len/2-1; i++) {
            mid = mid.next;
        }
        Node tmp = mid;
        mid = mid.next;
        tmp.next = null;
        head = sort(head, len/2);
        mid = sort(mid, len-len/2);
        return merge(head, mid);
    }

    private Node merge(Node low, Node high) {
        Node head = null;
        Node last = null;
        while (low != null && high != null) {
            if (low.item.compareTo(high.item) < 0) {
                if (head == null) {
                    head = low;
                } else {
                    last.next = low;
                }
                last = low;
                low = low.next;
            } else {
                if (head == null) {
                    head = high;
                } else {
                    last.next = high;
                }
                last = high;
                high = high.next;
            }
        }
        if (low == null) {
            last.next = high;
        } else {
            last.next = low;
        }
        return head;
    }

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void evenList() {
        Double[] a = {5.0, 1.0, 7.0, 3.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void oddList() {
        Double[] a = {5.0, 1.0, 7.0, 3.0, 0.5};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void alreadySorted() {
        Double[] a = {1.0, 2.0, 3.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void lowRunsOut() {
        Double[] a = {1.0, 2.0, 3.0, 7.0, 8.0, 9.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void highRunsOut() {
        Double[] a = {7.0, 8.0, 9.0, 1.0, 2.0, 3.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void lowHighEqual() {
        Double[] a = {4.0, 3.0, 2.0, 4.0, 3.0, 2.0};
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
        Iterator<Double> linkedListIterator = linkedlist.iterator();
        for (int i=0; i< linkedlist.count; i++){
            StdOut.println(linkedListIterator.next());
        }
    }

    public static void main(String[] args) {
        evenList();
        StdOut.println();
        oddList();
        StdOut.println();
        alreadySorted();
        StdOut.println();
        highRunsOut();
        StdOut.println();
        lowRunsOut();
        StdOut.println();
        lowHighEqual();
    }
}
