package Uke7.oppg2.SorteringsMetoder;

public class KvikksSortering {

    private static final int MIN_GRENSE = 3;

    // Public API: sorter hele tabellen
    public static <T extends Comparable<? super T>> void kvikksorter(T[] a) {
        if (a == null || a.length <= 1) return;
        kvikksorter(a, 0, a.length);   // siste er EKSKLUDERT
        sorterVedInnsetting(a);        // sluttpolering
    }

    // Kvikksortering på intervallet [forste, siste)
    private static <T extends Comparable<? super T>> void kvikksorter(T[] a, int forste, int siste) {

        // Tail recursion-optimalisering + sorter minste del først
        while (siste - forste > MIN_GRENSE) {

            int pivotIndex = partition(a, forste, siste);

            int venstreStorrelse = pivotIndex - forste;             // [forste, pivotIndex)
            int hogreStorrelse = siste - (pivotIndex + 1);          // (pivotIndex, siste)

            if (venstreStorrelse < hogreStorrelse) {
                kvikksorter(a, forste, pivotIndex);
                forste = pivotIndex + 1; // fortsett med høyre del i while
            } else {
                kvikksorter(a, pivotIndex + 1, siste);
                siste = pivotIndex;      // fortsett med venstre del i while
            }
        }
        // Basistilfelle: gjør ingenting her
        // Insertion sort kjører på hele tabellen i public-metoden
    }

    // Partition på [forste, siste) med median-of-three og pivot flyttet til siste-1
    private static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
        int midten = (forste + siste) / 2;

        // Sørg for at a[forste] <= a[midten] <= a[siste-1]
        sortFirstMiddleLast(a, forste, midten, siste - 1);

        // Flytt pivot (midten) til nest siste plass (siste-2? Nei: her bruker vi siste-2 bare om siste-1 er "last")
        // Vi bruker siste-2 som pivotplass hvis vi vil holde siste-1 som "last". Men i denne varianten:
        // siste-1 er faktisk last-indeks i intervallet, så pivot flyttes til siste-2 gir rot.
        // Derfor: pivot flyttes til siste-2 bare hvis vi hadde last = siste-1 og pivotIndex = last-1.
        // I foreleserkoden: pivot flyttes til siste-1 når siste er "inkludert". Her er siste ekskludert,
        // så "last index" = siste-1, og "nest siste" = siste-2.
        swap(a, midten, siste - 2);
        int pivotIndex = siste - 2;
        T pivotValue = a[pivotIndex];

        int fraVenstre = forste + 1;
        int fraHogre = siste - 3;

        boolean ferdig = false;
        while (!ferdig) {

            while (a[fraVenstre].compareTo(pivotValue) < 0) {
                fraVenstre++;
            }

            while (a[fraHogre].compareTo(pivotValue) > 0) {
                fraHogre--;
            }

            if (fraVenstre < fraHogre) {
                swap(a, fraVenstre, fraHogre);
                fraVenstre++;
                fraHogre--;
            } else {
                ferdig = true;
            }
        }

        // Plasser pivot riktig
        swap(a, pivotIndex, fraVenstre);
        return fraVenstre;
    }

    // --- Hjelpemetoder (samme som foreleser/bok) ---

    private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
        order(a, first, mid);
        order(a, mid, last);
        order(a, first, mid);
    }

    private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
        if (a[i].compareTo(a[j]) > 0) swap(a, i, j);
    }

    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Insertion sort på hele tabellen (du kan også bruke din egen)
    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }
}