public class EdgeCases {
    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = { 0.0 };

        Bubble.sort(a);     // bubble sort
        Selection.sort(a);  // selection sort
        Insertion.sort(a);  // insertion sort
        Shell.sort(a);      // Shellsort
        Quick.sort(a);      // quicksort
    }
}
