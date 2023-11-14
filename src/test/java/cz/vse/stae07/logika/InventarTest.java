package cz.vse.stae07.logika;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testovací třída InventarTest.
 * <p>
 * Testuje vložení předmětů a plnou kapacitu.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
class InventarTest {

    Inventar inventar;
    Predmet predmet1;
    Predmet predmet2;
    Predmet predmet3;
    Predmet predmet4;

    @BeforeEach
    public void setUp() throws Exception {

        inventar = new Inventar();
        predmet1 = new Predmet("predmet1", false, " Toto je předmět 1.");
        predmet2 = new Predmet("predmet2", false, " Toto je předmět 2.");
        predmet3 = new Predmet("predmet3", false, " Toto je předmět 3.");
        predmet4 = new Predmet("predmet4", false, " Toto je předmět 4.");
    }


    @Test
    void pridejPredmetAOdeber() {
        assertTrue(inventar.pridejPredmet(predmet1));
        assertTrue(inventar.pridejPredmet(predmet2));
        assertTrue(inventar.pridejPredmet(predmet3));
        assertFalse(inventar.pridejPredmet(predmet4));
        inventar.odeberPredmet(predmet3);
        assertTrue(inventar.pridejPredmet(predmet4));


    }

}
