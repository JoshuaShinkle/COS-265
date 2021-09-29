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

    public int opcount = 0;
    public int size =0;
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

    }

    // pushes item to top of steque
    public void push(Item item) {

    }

    // pops and returns top item
    public Item pop() throws NoSuchElementException {
        return null;
    }

    // returns new Iterator<Item> that iterates over items in steque
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    // perform unit testing here
    public static void main(String[] args) throws NoSuchElementException {

    }
}