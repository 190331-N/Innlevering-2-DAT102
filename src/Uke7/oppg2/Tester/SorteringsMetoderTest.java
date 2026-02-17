package Uke7.oppg2.Tester;

import Uke7.oppg2.SorteringsMetoder.FletteSortering;
import Uke7.oppg2.SorteringsMetoder.Innsettingsmetode;
import Uke7.oppg2.SorteringsMetoder.KvikksSortering;
import Uke7.oppg2.SorteringsMetoder.UtvalgsSortering;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorteringsMetoderTest {

    private Integer[] a;

    @BeforeEach
    void setUp() {
        a = new Integer[]{5, 0, 7, 1, 2, 8, 12, 10, 27, 15, 4};
    }

    @Test
    void testSorterVedInnsetting() {
        Innsettingsmetode.sorterVedInnsetting(a);
        assertTrue(erSortert(a));
    }

    @Test
    void testUtvalgssortering() {
        UtvalgsSortering.utvalgssortering(a);
        assertTrue(erSortert(a));
    }

    @Test
    void testKvikksortering() {
        KvikksSortering.kvikksorter(a);
        assertTrue(erSortert(a));
    }

    @Test
    void testFlettesortering() {
        FletteSortering.flettesortering(a);
        assertTrue(erSortert(a));
    }


    private boolean erSortert(Integer[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i].compareTo(tab[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}







