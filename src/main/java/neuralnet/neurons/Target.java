package neuralnet.neurons;

public class Target {

    private Neuron neuron;

    private double multiplier;

    public void send(double output) {
        neuron.trigger(output * multiplier);
    }

    public Target(Neuron neuron) {
        this(neuron, 1);
    }

    public Target(Neuron neuron, double multiplier) {
        this.neuron = neuron;
        this.multiplier = multiplier;
    }
}
