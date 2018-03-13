package neuralnet;

import neuralnet.neurons.Neuron;

import java.util.Iterator;
import java.util.LinkedHashSet;


public class Layer {

    private LinkedHashSet<Neuron> neurons;


    public Layer(int amountOfNeurons, Layer targets) {
        this(amountOfNeurons, targets, false);
    }

    public Layer(int amountOfNeurons, Layer targets, boolean isInputLayer) {
        for (int i = 0; i < amountOfNeurons; i++) {
            neurons.add(new Neuron(isInputLayer));
        }

        if (targets != null) {
            neurons.parallelStream().forEach(neuron -> neuron.addTarget(neuron));
        }
    }

    public Layer(Layer other) {
        other.getNeurons().forEach(neuron -> neurons.add(new Neuron(neuron)));
    }


    public void sendOutputs() {
        neurons.parallelStream().forEach(Neuron::sendOutputToTargets);
    }


    public LinkedHashSet<Neuron> getNeurons() {
        return neurons;
    }

    public void receiveInputs(double[] inputs) {
        Iterator<Neuron> it = neurons.iterator();
        for (double input : inputs) {
            if (it.hasNext()) {
                Neuron currentNeuron = it.next();
                currentNeuron.receiveInput(input);
            } else {
                return;
            }
        }
    }

    public LinkedHashSet<Double> getOutputs() {
        LinkedHashSet<Double> outputs = new LinkedHashSet<>();

        for (Neuron neuron : neurons) {
            outputs.add(neuron.calculateOutput());
        }

        return outputs;
    }
}
