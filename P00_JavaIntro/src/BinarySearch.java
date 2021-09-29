import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        // returns the index position of key in a if it exists
        // else, returns -1
        int low = 0;
        int high = a.length-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(key < a[mid]) high = mid - 1;
            else if(key > a[mid]) low = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        // read ints from args[0] and store in whitelist
        // read ints from args[1] and store in checklist
        // print each int that is in checklist but is not in whitelist
        Stopwatch runtime = new Stopwatch();

        In in1 = new In(args[0]);
        int[] whitelist = in1.readAllInts();
        In in2 = new In(args[1]);
        int[] checklist = in2.readAllInts();
        Arrays.sort(whitelist);

        for(int i=0; i<checklist.length; i++){
            if(rank(checklist[i], whitelist) == -1) {
                System.out.print(checklist[i]);
                System.out.print(" ");
            }
        }

        StdOut.println("elapsed time: " + runtime.elapsedTime());
    }
}
