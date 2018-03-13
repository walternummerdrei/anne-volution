package neuralnet;

import java.util.LinkedHashSet;


public class Anne {

    private Layer inputLayer;

    private Layer[] hiddenLayers;

    private Layer outputLayer;

    public Anne(int amountInputNeurons, int amountHiddenLayers, int neuronsPerHiddenLayer, int amountOutputNeurons) {
        // create output layer
        outputLayer = new Layer(amountOutputNeurons, null, false);

        // create hidden layers
        hiddenLayers = new Layer[amountHiddenLayers];
        hiddenLayers[amountHiddenLayers - 1] = new Layer(neuronsPerHiddenLayer, outputLayer, false);
        for (int i = amountHiddenLayers - 2; i >= 0; i--) {
            hiddenLayers[i] = new Layer(neuronsPerHiddenLayer, hiddenLayers[i + 1], false);
        }

        // create input layer
        inputLayer = new Layer(amountInputNeurons, hiddenLayers[0], true);
    }

    public Anne(Anne other) {
        this.inputLayer = new Layer(other.inputLayer);

        this.hiddenLayers = new Layer[other.hiddenLayers.length];
        for (int i = 0; i < hiddenLayers.length; i++) {
            hiddenLayers[i] = new Layer(other.hiddenLayers[i]);
        }

        this.outputLayer = new Layer(other.outputLayer);
    }

    public LinkedHashSet<Double> processInputs(double[] inputs) {
        inputLayer.receiveInputs(inputs);
        inputLayer.sendOutputs();

        for (Layer layer : hiddenLayers) {
            layer.sendOutputs();
        }

        return outputLayer.getOutputs();
    }

}
