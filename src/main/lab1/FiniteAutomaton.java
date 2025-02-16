package main.lab1;

import java.util.*;

public class FiniteAutomaton {
    private Set<String> Q = new HashSet<>(Arrays.asList("S", "A", "B", "C"));
    private Set<Character> Sigma = new HashSet<>(Arrays.asList('a', 'b'));
    private Map<String, Map<Character, String>> delta;
    private String q0 = "S";
    private Set<String> F = new HashSet<>(Arrays.asList("C"));

    public FiniteAutomaton() {
        delta = new HashMap<>();
        for (String state : Q) delta.put(state, new HashMap<>());

        delta.get("S").put('a', "A");
        delta.get("A").put('b', "S");
        delta.get("A").put('a', "B");
        delta.get("B").put('b', "C");
        delta.get("B").put('a', "B");
        delta.get("C").put('a', "A");
        delta.get("C").put('b', "");
    }

    public boolean stringBelongToLanguage(String input) {
        String currentState = q0;
        for (char symbol : input.toCharArray()) {
            if (!Sigma.contains(symbol)) return false;
            currentState = delta.getOrDefault(currentState, new HashMap<>()).getOrDefault(symbol, "");
            if (currentState.isEmpty()) return false;
        }

        System.out.println("Finite Automaton Transitions:");
        for (String state : delta.keySet()) {
            for (Character symbol : delta.get(state).keySet()) {
                System.out.println(state + " --" + symbol + "--> " + delta.get(state).get(symbol));
            }
        }


        return F.contains(currentState);
    }
}
