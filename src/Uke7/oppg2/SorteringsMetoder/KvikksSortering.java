package Uke7.oppg2.SorteringsMetoder;

import java.util.Random;

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
    public static Integer[] tilfeldigTabell() {
        int i1 = 1;
        Random tilfeldig = new Random(5);
        int n = 50000;
        Integer[] tabell = new Integer[n];

        for (int i = 0; i < n; i++) {
            tabell[i] = tilfeldig.nextInt(50000);
        }
        return tabell;
    }

    public static long målTid(Runnable r) {
        long start = System.nanoTime();
        r.run();
        long slutt = System.nanoTime();
        return slutt - start;
    }
    public static void main(String[] args) {
        Integer[] tab = tilfeldigTabell();
        long total = 0;
        int n = 10;
        for (int i = 0; i < n; i++) {
            long tid = målTid(() -> kvikksorter(tilfeldigTabell()));
            System.out.println("Tid: " + (tid / 1_000_000) + " ms");
            total+=tid;
        }
        System.out.println((total/n)/1000000);
    }
}
