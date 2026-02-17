package Uke7.oppg2.SorteringsMetoder;

import java.util.Random;

public class Innsettingsmetode {

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T temp = a[i];      // elementet som skal setjast inn
            int j = i - 1;

            // Flytt element som er større enn verdi eitt steg til høgre
            while (j >= 0 && a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            // Set inn elementet på rett plass
            a[j + 1] = temp;
        }
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

    public static void skrivUt(Integer[] tab){
        for (int tabell : tab) {
            System.out.println(tabell);
        }
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
            long tid = målTid(() -> sorterVedInnsetting(tilfeldigTabell()));
            System.out.println("Tid: " + (tid / 1_000_000) + " ms");
            total+=tid;
        }
        System.out.println((total/n)/1000000);
    }
}
