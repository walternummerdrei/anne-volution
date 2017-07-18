package generation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * DOCUMENTATION
 *
 * @author Jonathan Harhoff (j.harhoff@tarent.de)
 */
public class GenerationTest {
    private Generation generation;

    @Test
    public void createGenerationWithSizeTest() {
        for (int i = 0; i < 3; i++) {
            generation = new Generation(i * 2);
            assertEquals(i * 2, generation.getAmountOfAnnes());
        }
    }

    @Test
    public void createGenerationFromJsonTest() {

    }

    @Test
    public void createGenerationFromOldGenTest() {
        generation = new Generation(10);
        generation.setAmountOfAnnes(20);

        generation = new Generation(generation);
        assertEquals(20, generation.getAmountOfAnnes());
    }
}
