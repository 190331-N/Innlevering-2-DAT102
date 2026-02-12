public class ParantesSjekker {



    private boolean erStartParentes(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private boolean erSluttParentes(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private boolean erParentesPar(char start, char slutt) {
        return (start == '{' && slutt == '}')
                || (start == '[' && slutt == ']')
                || (start == '(' && slutt == ')');
    }
}
