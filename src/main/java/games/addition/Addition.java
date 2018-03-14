package games.addition;

import neuralnet.Anne;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Addition {

    public static void main(String[] args) {
        LinkedList<Anne> annes = new LinkedList<>();

        int amountOfAnnes = 50;

        for (int i = 0; i < amountOfAnnes; i++) {
            annes.add(new Anne(6, 3, 10, 1));
        }

        LinkedList<Double> inputs = new LinkedList<>();
        Map<Double, Anne> results = new HashMap<>();

        for (int i = 0; i < 100; i++) {

            int number1 = i % 8;
            int number2 = (i + 1) % 8;

            // number 1
            inputs.add(i % 8 >= 4 ? 1D : 0D);
            inputs.add(i % 4 >= 2 ? 1D : 0D);
            inputs.add(i % 2 >= 1 ? 1D : 0D);

            // number 2
            inputs.add(i + 1 % 8 >= 4 ? 1D : 0D);
            inputs.add(i + 1 % 4 >= 2 ? 1D : 0D);
            inputs.add(i + 1 % 2 >= 1 ? 1D : 0D);

            annes.parallelStream().forEach(anne -> results.put(anne.processInputs(inputs).getFirst(), anne));

            Map.Entry<Double, Anne> winner = results.entrySet().stream().reduce((r1, r2) -> Math.abs(r1.getKey() - (number1 + number2)) > Math.abs(r2.getKey() - (number1 + number2)) ? r2 : r1).get();

            Anne bestAnne = winner.getValue();

            System.out.println("Result:          " + (number1 + number2));
            System.out.println("Best difference: " + ((number1 + number2) - winner.getKey()));
            System.out.println("");

            for (int j = 0; j < amountOfAnnes; j++) {
                annes.add(bestAnne);
            }
        }

        System.out.println("DONE");


    }
}
