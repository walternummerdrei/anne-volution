package neuralnet.neurons;

import neuralnet.neurons.activation.ActivationFunction;

import java.util.Set;


public abstract class Neuron {

    private Set<Target> targets;

    private ActivationFunction activationFunction;

    private double inputs;

    private double bias;

    public Neuron(Neuron neuron) {
        this.targets = neuron.getTargets();
        this.activationFunction = neuron.getActivationFunction();
        this.bias = neuron.getBias();
    }

    public void trigger(double input) {
        this.inputs += input;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getInputs() {
        return inputs;
    }

    public void setInputs(double inputs) {
        this.inputs = inputs;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public Set<Target> getTargets() {
        return targets;
    }

    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }
}
