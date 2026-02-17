package Uke7.oppg2.SorteringsMetoder;

public class KvikksSortering {

    public static <T extends Comparable<? super T>> void kvikksorter(T[] a) {
        kvikksorter(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void kvikksorter(T[] a, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(a, low, high);
        kvikksorter(a, low, pivotIndex - 1);
        kvikksorter(a, pivotIndex + 1, high);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high) {
        T pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}