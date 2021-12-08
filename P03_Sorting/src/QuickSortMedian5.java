import java.util.Arrays;
import java.util.Collections;

/**
 * The following code is *mostly* a copy of Quick class (quick sort) from algs4.jar
 */

public class QuickSortMedian5 extends QuickSortMedian {

    public static class MedianOf5 extends MedianOfN {
        public MedianOf5() {
            // tell QuickSortMedian.MedianOfN we will find the median of 5 items
            super(5);
        }

        /***********************************************************
         * Determines which index in parameter indices points to
         * the median value in parameter a
         * @param a the array containing values
         * @param indices the array containing indices into a
         * @return the index of median value
         ***********************************************************/
        public int median(Comparable[] a, int[] indices) {
            // get values at specified indices
            int i0 = indices[0];
            int i1 = indices[1];
            int i2 = indices[2];
//            int i3 = indices[3];
//            int i4 = indices[4];
//            Comparable a0 = a[i0];
//            Comparable a1 = a[i1];
//            Comparable a2 = a[i2];
//            Comparable a3 = a[i3];
//            Comparable a4 = a[i4];
//
//            Comparable[] arrayOf5 = new Comparable[5];
//            arrayOf5[0] = a0;
//            arrayOf5[1] = a1;
//            arrayOf5[2] = a2;
//            arrayOf5[3] = a3;
//            arrayOf5[4] = a4;
            Comparable a0 = null;
            Comparable a1 = null;
            Comparable a2 = null;

            // find median in a0,a1,a2,a3,a4, and return respective index
            Comparable maxNum = Collections.max(Arrays.asList(a));
            Comparable minNum = Collections.min(Arrays.asList(a));
//            Comparable[] arrayOf3 = new Comparable[3];
//            int count = 0;
            int a0a1a2Count = 0;
            boolean maxRemoved = false;
            boolean minRemoved = false;
            for (int i=0; i<5; i++) {
               if (a[i] == maxNum && !maxRemoved) {
                    maxRemoved = true;
               } else if (a[i] == minNum && !minRemoved) {
                   minRemoved = true;
               } else {
                   if (a0a1a2Count == 0) {
                       a0 = a[i];
                       i0 = indices[i];
                   } else if (a0a1a2Count == 1) {
                       a1 = a[i];
                       i1 = indices[i];
                   } else {
                       a2 = a[i];
                       i2 = indices[i];
                   }
                   a0a1a2Count++;
//                   count++;
               }
            }

//            a0 = arrayOf3[0];
//            a1 = arrayOf3[1];
//            a2 = arrayOf3[2];

            if ((a0.compareTo(a1) <= 0 && a0.compareTo(a2) >= 0) || (a0.compareTo(a1) >= 0 && a0.compareTo(a2) <= 0)) {
                return i0;
            }
            // if a1 is median, return i1
            if ((a1.compareTo(a0) <= 0 && a1.compareTo(a2) >= 0) || (a1.compareTo(a0) >= 0 && a1.compareTo(a2) <= 0)) {
                return i1;
            }
            // if a2 is median, return i2
            return i2;
        }
    }

    /***********************************************************************
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     ***********************************************************************/
    public static void sort(Comparable[] a) {
        MedianOf5 median = new MedianOf5();
        QuickSortMedian.sort(a, median);
    }


    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = {6.0, 7.0, 3.0, 4.0, 5.0};
        QuickSortMedian5.sort(a);
    }
}
