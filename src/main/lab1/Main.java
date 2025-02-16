package main.lab1;

public class Main {
    public static void main(String[] args) {
        Grammar grammar = new Grammar();
        System.out.println("Generated Strings:");
        for (int i = 0; i < 5; i++) {
            System.out.println(grammar.generateString());
        }

        FiniteAutomaton fa = grammar.toFiniteAutomaton();
        System.out.println("Testing FA:");
        System.out.println("Does 'abab' belong? " + fa.stringBelongToLanguage("abab"));
        System.out.println("Does 'aaabb' belong? " + fa.stringBelongToLanguage("aaabb"));
    }
}
