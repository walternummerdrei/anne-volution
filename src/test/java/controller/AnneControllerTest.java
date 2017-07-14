package controller;

import anne.Anne;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * DOCUMENTATION
 *
 * @author Jonathan Harhoff (j.harhoff@tarent.de)
 */
public class AnneControllerTest {

    Anne anne;
    AnneController ac = new AnneController();

    @Test
    public void createTest() {
        anne = ac.create();
        assertEquals(Anne.class, anne.getClass());
    }

    @Test
    public void anneToJsonTest() {
        anne = ac.create();
        String json = ac.anneToJson(anne);
        assertNotNull(json);
    }

    @Test
    public void jsonToAnneTest() {
        String json = new String();
        anne = ac.jsonToAnne(json);
        assertEquals(Anne.class, anne.getClass());
    }
}
