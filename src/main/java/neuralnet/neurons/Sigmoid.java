package neuralnet.neurons;

public class Sigmoid {

    public static double calculateFor(double x) {
        return calculateFor(x, 1);
    }

    public static double calculateFor(double x, double intensity) {
        return x / (intensity + Math.abs(x));
    }

    public static double calculateMutationValue(double random) {
        return calculateMutationValue(random, 1);
    }

    public static double calculateMutationValue(double random, double intensity) {
        double x = random - 0.5;
        return x / (intensity + Math.abs(x));
    }
}
