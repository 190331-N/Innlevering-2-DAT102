package Uke7.oppg2.SorteringsMetoder;

public class UtvalgsSortering {
    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Finn indeksen til minste element i resten av tabellen
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Bytt plass viss vi fann ein mindre
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }
    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a) {
        utvalgssortering(a, a.length);
    }

    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
