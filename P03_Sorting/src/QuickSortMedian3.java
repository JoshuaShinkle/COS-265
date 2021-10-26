/**
 * The following code is *mostly* a copy of Quick class (quick sort) from algs4.jar
 */

public class QuickSortMedian3 extends QuickSortMedian {

    public static class MedianOf3 extends MedianOfN {
        public MedianOf3() {
            // tell QuickSortMedian.MedianOfN we will find the median of 3 items
            super(3);
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
            Comparable a0 = a[i0];
            Comparable a1 = a[i1];
            Comparable a2 = a[i2];

            // find median in a0,a1,a2, and return respective index
            // if a0 is median, return i0
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
        MedianOf3 median = new MedianOf3();
        sort(a, median);
    }

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = {0.0, 3.0, 0.0};
        QuickSortMedian3.sort(a);
    }
}
