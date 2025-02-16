package main.lab1;

import java.util.*;

public class Grammar {

    private Set<String> VN;
    private Set<Character> VT;
    private Map<String, List<String>> P;
    private String startSymbol;

    public Grammar() {
        VN = new HashSet<>(Arrays.asList("S", "A", "B", "C"));
        VT = new HashSet<>(Arrays.asList('a', 'b'));
        P = new HashMap<>();
        startSymbol = "S";

        P.put("S", Arrays.asList("aA"));
        P.put("A", Arrays.asList("bS", "aB"));
        P.put("B", Arrays.asList("bC", "aB"));
        P.put("C", Arrays.asList("aA", "b"));
    }

    public String generateString() {
        StringBuilder result = new StringBuilder();
        String current = startSymbol;
        Random rand = new Random();

        while (!current.isEmpty() && !VT.contains(current.charAt(current.length() - 1))) {
            List<String> productions = P.get(current);
            if (productions == null || productions.isEmpty()) break; // Prevent empty state issue

            String chosenProduction = productions.get(rand.nextInt(productions.size()));
            result.append(chosenProduction.charAt(0));

            // Ensure the rest of the production exists before updating current
            if (chosenProduction.length() > 1) {
                current = chosenProduction.substring(1);
            } else {
                break; // Avoid empty state issues
            }
        }

        result.append(current);
        return result.toString();
    }


    public FiniteAutomaton toFiniteAutomaton() {
        return new FiniteAutomaton();
    }

}
