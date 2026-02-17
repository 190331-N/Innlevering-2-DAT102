package Uke6.ParanteSjekker;

import java.util.Stack;

public class ParentesSjekker {

    public boolean sjekkParenteser(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){

            if (erStartParentes(c)){
                stack.push(c);

            } else if (erSluttParentes(c)) {

                if (stack.isEmpty()){
                    return false;
                }

                char start = stack.pop();

                if (!erParentesPar(start, c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean erStartParentes(char c){
        return c == '(' || c == '{' || c == '[';
    }
    private boolean erSluttParentes(char c){
        return c == ')' || c == '}' || c == ']';
    }
    private boolean erParentesPar(char start, char slutt){
        return (start == '(' && slutt == ')') ||
                (start == '{' && slutt == '}') ||
                (start == '[' && slutt == ']');
    }
}
