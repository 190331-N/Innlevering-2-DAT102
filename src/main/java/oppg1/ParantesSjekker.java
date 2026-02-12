package java.oppg1;

public class ParantesSjekker {

    public boolean sjekkParenteser(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        StabelADT<Character> stabel = new LenketStabel<>();

        for (char c : s.toCharArray()) {

            if (erStartParentes(c)) {
                stabel.push(c);

            } else if (erSluttParentes(c)) {

                if (stabel.isEmpty()) {
                    return false;
                }

                char start = stabel.pop();

                if (!erParentesPar(start, c)) {
                    return false;
                }
            }
        }

        return stabel.isEmpty();
    }

        private boolean erStartParentes ( char c){
            return c == '{' || c == '[' || c == '(';
        }

        private boolean erSluttParentes ( char c){
            return c == '}' || c == ']' || c == ')';
        }

        private boolean erParentesPar ( char start, char slutt){
            return (start == '{' && slutt == '}')
                    || (start == '[' && slutt == ']')
                    || (start == '(' && slutt == ')');
        }
    }