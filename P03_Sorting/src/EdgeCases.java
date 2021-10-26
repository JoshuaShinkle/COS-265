import java.util.function.DoubleBinaryOperator;

public class EdgeCases {

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        // sorted
        Double[] sorted = {0.0, 1.0, 2.0, 3.0, 4.0};
        Bubble.sort(sorted);     // bubble sort
        Selection.sort(sorted);  // selection sort
        Insertion.sort(sorted);  // insertion sort
        Shell.sort(sorted);      // Shellsort
        Quick.sort(sorted);      // quicksort

        // reversed
        Double[] reversed1 = {4.0, 3.0, 2.0, 1.0, 0.0};
        Bubble.sort(reversed1);     // bubble sort
        Double[] reversed2 = {4.0, 3.0, 2.0, 1.0, 0.0};
        Selection.sort(reversed2);  // selection sort
        Double[] reversed3 = {4.0, 3.0, 2.0, 1.0, 0.0};
        Insertion.sort(reversed3);  // insertion sort
        Double[] reversed4 = {4.0, 3.0, 2.0, 1.0, 0.0};
        Shell.sort(reversed4);      // Shellsort
        Double[] reversed5 = {4.0, 3.0, 2.0, 1.0, 0.0};
        Quick.sort(reversed5);      // quicksort

        // all keys are same
        Double[] same = {3.0, 3.0, 3.0, 3.0, 3.0};
        Bubble.sort(same);     // bubble sort
        Selection.sort(same);  // selection sort
        Insertion.sort(same);  // insertion sort
        Shell.sort(same);      // Shellsort
        Quick.sort(same);      // quicksort

        // two distinct only
        Double[] twoDistinct1 = {0.0, 0.0, 5.0, 4.0, 0.0};
        Bubble.sort(twoDistinct1);     // bubble sort
        Double[] twoDistinct2 = {0.0, 0.0, 5.0, 4.0, 0.0};
        Selection.sort(twoDistinct2);  // selection sort
        Double[] twoDistinct3 = {0.0, 0.0, 5.0, 4.0, 0.0};
        Insertion.sort(twoDistinct3);  // insertion sort
        Double[] twoDistinct4 = {0.0, 0.0, 5.0, 4.0, 0.0};
        Shell.sort(twoDistinct4);      // Shellsort
        Double[] twoDistinct5 = {0.0, 0.0, 5.0, 4.0, 0.0};
        Quick.sort(twoDistinct5);      // quicksort

        // size 0
        Double[] size0 = {};
        Bubble.sort(size0);     // bubble sort
        Selection.sort(size0);  // selection sort
        Insertion.sort(size0);  // insertion sort
        Shell.sort(size0);      // Shellsort
        Quick.sort(size0);      // quicksort

        // size 1
        Double[] size1 = {0.0};
        Bubble.sort(size1);     // bubble sort
        Selection.sort(size1);  // selection sort
        Insertion.sort(size1);  // insertion sort
        Shell.sort(size1);      // Shellsort
        Quick.sort(size1);      // quicksort
    }
}
