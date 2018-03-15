package games.addition;

import neuralnet.Anne;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Addition {

    public static void main(String[] args) {
        LinkedList<Anne> annes = new LinkedList<>();

        int amountOfAnnes = 100;
        int generations = 100;
        int turnsPerGeneration = 10;

        for (int i = 0; i < amountOfAnnes; i++) {
            annes.add(new Anne(6, 5, 10, 1));
        }

        LinkedList<Double> inputs = new LinkedList<>();
        Map<Anne, Double> results = new HashMap<>();

        for (int i = 0; i < generations; i++) {
            results.clear();
            annes.forEach(anne -> results.put(anne, 0D));

            for (int j = 0; j < turnsPerGeneration; j++) {

                inputs.clear();

                int number1 = j % 8;
                int number2 = (j + 1) % 8;

                // number 1
                inputs.add(j % 8 >= 4 ? 1D : 0D);
                inputs.add(j % 4 >= 2 ? 1D : 0D);
                inputs.add(j % 2 >= 1 ? 1D : 0D);

                // number 2
                inputs.add(j + 1 % 8 >= 4 ? 1D : 0D);
                inputs.add(j + 1 % 4 >= 2 ? 1D : 0D);
                inputs.add(j + 1 % 2 >= 1 ? 1D : 0D);

                results.entrySet().parallelStream()
                        .forEach(entry -> {
                            Anne anne = entry.getKey();
                            double oldDeviation = entry.getValue();
                            double additionalDeviation = number1 + number2 - anne.processInputs(inputs).getFirst();
                            entry.setValue(oldDeviation + additionalDeviation);
                        });
            }

            Map.Entry<Anne, Double> winner = results.entrySet().stream().reduce((r1, r2) -> Math.abs(r1.getValue()) < Math.abs(r2.getValue()) ? r1 : r2).get();
            Anne bestAnne = winner.getKey();

            System.out.println("Generation:     " + i);
            System.out.println("Best deviation: " + (winner.getValue()));
            System.out.println("");

            annes.clear();

            for (int k = 0; k < amountOfAnnes; k++) {
                annes.add(new Anne(bestAnne));
            }

        }

        System.out.println("DONE");


    }
}
