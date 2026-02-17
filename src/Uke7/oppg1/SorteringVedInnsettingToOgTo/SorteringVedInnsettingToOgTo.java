package Uke7.oppg1.SorteringVedInnsettingToOgTo;

import java.util.Random;

public class SorteringVedInnsettingToOgTo {
    
    public static <T extends Comparable<? super T>> void flyttMinstForst(T[] a) {
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        while (minIndex > 0) {
            T tmp = a[minIndex];
            a[minIndex] = a[minIndex - 1];
            a[minIndex - 1] = tmp;
            minIndex--;
        }
    }
    public static <T extends Comparable<? super T>> void sorterVedInnsettingToOgTo(T[] a) {
        int n = a.length;
        if (n < 2) return;

        flyttMinstForst(a);

        // Vi held a[0..i-1] sortert. Vi set inn to og to frå i og i+1.
        for (int i = 1; i + 1 < n; i += 2) {
            T x = a[i];
            T y = a[i + 1];

            T minste = x;
            T storste = y;
            if (x.compareTo(y) > 0) {
                minste = y;
                storste = x;
            }

            int j = i - 1;

            while (j > 0 && a[j].compareTo(storste) > 0) {
                a[j + 2] = a[j];
                j--;
            }

            a[j + 2] = storste;

            while (j > 0 && a[j].compareTo(minste) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = minste;
        }

        if (n % 2 == 0) {
            T temp = a[n - 1];
            int j = n - 2;
            while (j > 0 && a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static Integer[] tilfeldigTabell() {
        Random tilfeldig = new Random(5);
        int n = 100000;
        Integer[] tabell = new Integer[n];

        for (int i = 0; i < n; i++) {
            tabell[i] = tilfeldig.nextInt(100000);
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
        for (int i = 0; i < n ; i++) {
            long tid = målTid(() -> sorterVedInnsettingToOgTo(tilfeldigTabell()));
            System.out.println("Tid: " + (tid / 1_000_000) + " ms");
            total+= tid;
        }
        long gjennomsnitt = total/n;
        System.out.println(gjennomsnitt/1000000);
    }
}
