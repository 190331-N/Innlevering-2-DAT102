package Uke7.oppg2.SorteringsMetoder;

import java.util.Random;

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
    public static Integer[] tilfeldigTabell() {
        Random tilfeldig = new Random(5);
        int n = 50000;
        Integer[] tabell = new Integer[n];

        for (int i = 0; i < n; i++) {
            tabell[i] = tilfeldig.nextInt(50000);
        }
        return tabell;
    }

    public static long malTid(Runnable r) {
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
            long tid = malTid(() -> utvalgssortering(tilfeldigTabell()));
            System.out.println("Tid: " + (tid / 1_000_000) + " ms");
            total+=tid;
        }
        System.out.println((total/n)/1000000);
    }
}

