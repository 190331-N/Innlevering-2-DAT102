package oppg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParantesSjekkerTest {

    @Test
    void testTomStreng() {
        ParantesSjekker ps = new ParantesSjekker();
        assertTrue(ps.sjekkParenteser(""));
    }

    @Test
    void testNullStreng() {
        ParantesSjekker ps = new ParantesSjekker();
        assertTrue(ps.sjekkParenteser(null));
    }

    @Test
    void testKorrekteParenteser() {
        ParantesSjekker ps = new ParantesSjekker();
        assertTrue(ps.sjekkParenteser("{[()]}"));
    }

    @Test
    void testFeilTypeParentes() {
        ParantesSjekker ps = new ParantesSjekker();
        assertFalse(ps.sjekkParenteser("{[(])}"));
    }

    @Test
    void testSluttUtenStart() {
        ParantesSjekker ps = new ParantesSjekker();
        assertFalse(ps.sjekkParenteser(")"));
    }

    @Test
    void testStartUtenSlutt() {
        ParantesSjekker ps = new ParantesSjekker();
        assertFalse(ps.sjekkParenteser("((("));
    }

    @Test
    void testIgnorerAndreTegn() {
        ParantesSjekker ps = new ParantesSjekker();

        String kode =
                "public class Test {\n" +
                        "   public static void main(String[] args) {\n" +
                        "       System.out.println(\"Hei\");\n" +
                        "   }\n" +
                        "}";

        assertTrue(ps.sjekkParenteser(kode));
    }
}
