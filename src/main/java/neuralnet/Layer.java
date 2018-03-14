package neuralnet;

import neuralnet.neurons.Neuron;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;


public class Layer {

    private LinkedHashSet<Neuron> neurons = new LinkedHashSet<>();


    public Layer(int amountOfNeurons, Layer targets) {
        this(amountOfNeurons, targets, false);
    }

    public Layer(int amountOfNeurons, Layer targets, boolean isInputLayer) {
        for (int i = 0; i < amountOfNeurons; i++) {
            neurons.add(new Neuron(isInputLayer));
        }

        if (targets != null) {
            for (Neuron neuron : neurons) {
                targets
                        .getNeurons()
                        .forEach(targetNeuron ->
                                neuron.addTarget(targetNeuron)
                        );
            }
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

    public void receiveInputs(LinkedList<Double> inputs) {
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

    public LinkedList<Double> getOutputs() {
        LinkedList<Double> outputs = new LinkedList<>();

        for (Neuron neuron : neurons) {
            outputs.add(neuron.calculateOutput());
        }

        return outputs;
    }
}
