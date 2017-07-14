package controller;

import generation.Generation;

/**
 * The generation controller, intended to manage a List<>() of NNs
 * These methods are available to the user of the library
 *
 * @author Jonathan Harhoff (j.harhoff@tarent.de)
 */
public class GenerationController {

    public Generation create(int amountOfAnnes) {
        return new Generation();
    }

    /**
     * Exports the provided generation to json
     *
     * TODO: Save to file
     *
     * @param generation
     * @return
     */
    public String generationToJson(Generation generation) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    /**
     * Creates a new generation from json
     *
     * @param json
     * @return
     */
    public Generation jsonToGeneration(String json) {
        return new Generation();
    }

    /**
     * This method repopulates a List of neural networks by keeping the successful NNs and generating new ones from their genes.
     *
     * @param generationSize the amount of neural networks that gets returned
     * @param oldGeneration the neural networks to keep alive and create new NNs from
     * @return next generation of NNs
     */
    public Generation repopulate(int generationSize, Generation oldGeneration) {
        Generation nextGeneration = new Generation();

        return nextGeneration;
    }
}
