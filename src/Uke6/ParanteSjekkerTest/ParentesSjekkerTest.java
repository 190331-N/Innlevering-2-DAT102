package Uke6.ParanteSjekkerTest;

import Uke6.impl.ParentesSjekker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParentesSjekkerTest {

    ParentesSjekker sjekker = new ParentesSjekker();

    @Test
    void korrektEnkleParenteser() {
        assertTrue(sjekker.sjekkParenteser("()"));
        assertTrue(sjekker.sjekkParenteser("[]"));
        assertTrue(sjekker.sjekkParenteser("{}"));
    }

    @Test
    void korrektBlandedeParenteser() {
        assertTrue(sjekker.sjekkParenteser("{ [ ( ) ] }"));
        assertTrue(sjekker.sjekkParenteser("({[]})"));
    }

    @Test
    void manglerSluttparentes() {
        assertFalse(sjekker.sjekkParenteser("{ [ ( ) }"));
    }

    @Test
    void manglerStartparentes() {
        assertFalse(sjekker.sjekkParenteser("[ ( ) ] }"));
    }

    @Test
    void feilRekkefolge() {
        assertFalse(sjekker.sjekkParenteser("{ [ ( ] ) }"));
    }

    @Test
    void ingenParenteser() {
        assertTrue(sjekker.sjekkParenteser("Hei på deg!"));
    }

    @Test
    void parenteserIMiksMedKode() {
        String kode = """
            class Test {
                public static void main(String[] args) {
                    System.out.println("Hei");
                }
            }
            """;
        assertTrue(sjekker.sjekkParenteser(kode));
    }
}