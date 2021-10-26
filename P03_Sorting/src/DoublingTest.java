public class DoublingTest {

    public static void sort(String method) {
        double MAX = 1000000;
        for (int n=1000, count=0; count < 5; n*=2, count++) {
            double average = 0;
            for (int j=0; j<100; j++) {
                Double[] a = new Double[n];
                for (int i=0; i<n; i++) {
                    a[i] = StdRandom.uniform(-MAX, MAX);
                }
                Stopwatch timer = new Stopwatch();
                switch (method) {
                    case "Selection": Selection.sort(a);
                        break;
                    case "Insertion": Insertion.sort(a);
                        break;
                    case "Shell": Shell.sort(a);
                        break;
                    case "Quick": Quick.sort(a);
                        break;
                    case "Median3": QuickSortMedian3.sort(a);
                        break;
                    case "Median5": QuickSortMedian5.sort(a);
                        break;
                }
                average += timer.elapsedTime();
            }
            average /= 5;
            StdOut.printf("%s: N = %d || Time = %f || Ratio = %f\n", method, n, average, n/average);
        }
    }

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        sort("Selection");
        StdOut.println();
        sort("Insertion");
        StdOut.println();
        sort("Shell");
        StdOut.println();
        sort("Quick");
        StdOut.println();
        sort("Median3");
        StdOut.println();
        sort("Median5");
        StdOut.println();

        double MAX = 1000000;
        for (int n=1000, count=0; count < 5; n*=2, count++) {
            double average = 0;
            for (int j=0; j<100; j++) {
                Double[] a = new Double[n];
                for (int i=0; i<n; i++) {
                    a[i] = StdRandom.uniform(-MAX, MAX);
                }
                LinkedList<Double> linkedlist = new LinkedList<>(a);
                Stopwatch timer = new Stopwatch();
                linkedlist.sort();
                average += timer.elapsedTime();
            }
            average /= 5;
            StdOut.printf("Linked List: N = %d || Time = %f || Ratio = %f\n", n, average, n/average);
        }
    }
}
