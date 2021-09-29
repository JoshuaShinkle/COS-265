import java.util.Arrays;

public class BruteForceSearch {
    public static int rank(int key, int[] a) {
        // returns the index position of key in a if it exists
        // else, returns -1
        for(int i=0; i<a.length; i++) {
            if(key==a[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // read ints from args[0] and store in whitelist
        // read ints from args[1] and store in checklist
        // print each int that is in checklist but is not in whitelist
        Stopwatch runtime = new Stopwatch();
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        In test = new In(args[1]);
        int[] checklist = test.readAllInts();

        for(int i=0; i<checklist.length; i++) {
            if(rank(checklist[i], whitelist) == -1) {
                StdOut.println(checklist[i]);
            }
        }

        StdOut.println("elapsed time: " + runtime.elapsedTime());
    }
}
