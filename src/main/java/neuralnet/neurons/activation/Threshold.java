package neuralnet.neurons.activation;

public class Threshold extends ActivationFunction {

    private double threshold;

    public double use(double input) {
        return input >= threshold ? 1 : 0;
    }

    public Threshold() {
        this(1);
    }

    public Threshold(double threshold) {
        this.threshold = threshold;
    }
}
