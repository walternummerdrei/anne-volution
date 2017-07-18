package controller;

import anne.Anne;

/**
 * The neural network controller, intended to manage a single NN
 * These methods are available to the user of the library.
 *
 * @author Jonathan Harhoff (j.harhoff@tarent.de)
 */
public final class AnneController {

    static public Anne create() {
        return new Anne();
    }


    static public Anne jsonToAnne(String genome) {
        return new Anne();
    }

    /**
     * Converts a NN to json for storage purposes
     *
     * TODO: Save json to filename (provided as argument)
     *
     * @param anne
     * @return
     */
    static public String anneToJson(Anne anne) {
        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }

}
