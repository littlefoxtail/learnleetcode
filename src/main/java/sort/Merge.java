package sort;

public class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i;
        for (i = lo; i <= hi; i++) {
            //目标
           aux[i] = a[i];
        }
        i = lo;
        for (int k = lo; k < hi; k++) {
//            if (i > mid) {
//                a[k] =
//            }

        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length -1);

    }

    public static void main(String[] args) {
        String[] arr = {"9", "8", "7", "5", "6", "3", "2", "1"};
        sort(arr);
    }
}
