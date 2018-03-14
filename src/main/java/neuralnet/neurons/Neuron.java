package neuralnet.neurons;

import java.util.HashSet;
import java.util.Set;

import static java.util.concurrent.ThreadLocalRandom.current;
import static neuralnet.Settings.MUTATION_THRESHOLD;
import static neuralnet.Settings.RANDOM_LIMIT;
import static neuralnet.neurons.Sigmoid.calculateMutationValue;


public class Neuron {

    private Set<Target> targets = new HashSet<>();

    private boolean inputNeuron;

    private double activationIntensity;

    private double inputs;

    private double bias;

    private double threshold;

    public Neuron(boolean inputNeuron) {
        this.inputNeuron = inputNeuron;
        this.threshold = 0.5;
        this.activationIntensity = 1;
        this.bias = 0;
        mutate();
    }

    public Neuron(Neuron neuron) {
        this.inputNeuron = neuron.isInputNeuron();
        this.targets = neuron.getTargets();
        this.activationIntensity = neuron.getActivationIntensity();
        this.bias = neuron.getBias();
        mutate();
    }

    private void mutate() {
        if (current().nextDouble(RANDOM_LIMIT) <= MUTATION_THRESHOLD) {
            setBias(bias + calculateMutationValue(current().nextDouble(1)));
        }

        if (current().nextDouble(RANDOM_LIMIT) <= MUTATION_THRESHOLD) {
            setActivationIntensity(activationIntensity + calculateMutationValue(current().nextDouble(RANDOM_LIMIT)));
        }

        if (current().nextDouble(RANDOM_LIMIT) <= MUTATION_THRESHOLD) {
            setThreshold(threshold + calculateMutationValue(current().nextDouble(RANDOM_LIMIT)));
        }

        if (targets != null) {
            targets.parallelStream().forEach(target -> {
                if (current().nextDouble(RANDOM_LIMIT) <= MUTATION_THRESHOLD) {
                    target.setMultiplier(target.getMultiplier() + calculateMutationValue(current().nextDouble(RANDOM_LIMIT)));
                }
            });
        }
    }

    public void receiveInput(double input) {
        this.inputs += input;
    }

    public void sendOutputToTargets() {
        double biasedValue = inputs - bias;
        if (biasedValue > threshold) {
            targets.parallelStream().forEach(target -> target.send(biasedValue));
        }
        inputs = 0;
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

    public Set<Target> getTargets() {
        return targets;
    }

    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }

    public double getActivationIntensity() {
        return activationIntensity;
    }

    public void setActivationIntensity(double activationIntensity) {
        this.activationIntensity = activationIntensity;
    }

    public void addTarget(Neuron neuron) {
        targets.add(new Target(neuron, 1));
    }

    public double calculateOutput() {
        double biasedValue = inputs - bias;
        if (biasedValue > threshold) {
            inputs = 0;
            return biasedValue;
        } else {
            return 0;
        }
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public boolean isInputNeuron() {
        return inputNeuron;
    }
}
