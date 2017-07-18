package generation;

import anne.Anne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * DOCUMENTATION
 *
 * @author Jonathan Harhoff (j.harhoff@tarent.de)
 */
public class Generation {
    private int amountOfAnnes;
    private List<Anne> annes = new ArrayList<>();



    /**
     * This constructor is used to create an initial generation
     *
     * @param generationSize
     */
    public Generation(int generationSize) {
        this.amountOfAnnes = generationSize;
        IntStream.range(0, generationSize)
                .parallel()
                .forEach(i -> annes.add(new Anne()));
    }

    public Generation(String json) {
        // TODO: json-to-generation conversion
    }

    /**
     * Creates a new generation from an old one, automatically repopulates
     *
     * @param oldGen
     */
    public Generation(Generation oldGen) {
        amountOfAnnes = oldGen.getAmountOfAnnes();
        annes.addAll(oldGen.getAnnes());
        repopulate(amountOfAnnes - oldGen.getAnnes().size());
    }



    private void repopulate(int amountNewAnnes) {
        IntStream.range(0, amountOfAnnes - amountNewAnnes)
                .parallel()
                .forEach(i -> annes.add(new Anne()));
    }



    public List<Anne> getAnnes() {
        return annes;
    }

    public int getAmountOfAnnes() {
        return amountOfAnnes;
    }

    public void setAmountOfAnnes(int newAmount) {
        amountOfAnnes = newAmount;
    }
}
