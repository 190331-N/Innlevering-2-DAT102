package Uke7.oppg2.SorteringsMetoder;

import java.util.Random;

public class FletteSortering {

    public static <T extends Comparable<? super T>> void flettesortering(T[] a) {
        flettesortering(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void flettesortering(T[] a, int first, int last) {

        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast
        flettesortering(a, tempArray, first, last);
    }

    private static <T extends Comparable<? super T>> void flettesortering(T[] a, T[] tempTab, int forste, int siste) {

        if (forste >= siste) {
        }
        int midten = (forste+siste)/2;
        flettesortering(a, tempTab, forste, midten);
        flettesortering(a, tempTab,midten+1, siste);
        flett(a, tempTab, forste, midten, siste );
    }

    private static <T extends Comparable<? super T>> void flett(T[] a, T[] tempTab, int forste, int midten, int siste) {

        int fV = forste;
        int sluttV = midten;
        int fH = midten + 1;
        int sluttH = siste;

        int index = fV;
        for (; (fV <= sluttV) && (fH <= sluttH); index++) {
            if (a[fV].compareTo(a[fH]) < 0) {
                tempTab[index] = a[fV];
                fV++;
            } else {
                tempTab[index] = a[fH];
                fH++;
            }
        }
        for (; fV <= sluttV; fV++, index++) {
            tempTab[index] = a[fV];
        }

        for (; fH <= sluttH; fH++, index++) {
            tempTab[index] = a[fH];
        }

        for (index = forste; index <= siste; index++) {
            a[index] = tempTab[index];
        }
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
            long tid = malTid(() -> flettesortering(tilfeldigTabell()));
            System.out.println("Tid: " + (tid / 1_000_000) + " ms");
            total+=tid;
        }
        System.out.println((total/n)/1000000);
    }
}