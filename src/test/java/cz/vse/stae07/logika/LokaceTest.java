
package cz.vse.stae07.logika;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída slouží ke komplexnímu otestování třídy Lokace.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class LokaceTest {

    @Test
    public void testVychody() {
        Lokace lokace1 = new Lokace("ulice", "Docela nebezpečná ulice u jednoho z nejznámějších klubů v New York City.");
        Lokace lokace2 = new Lokace("klub", "Fuj tady to smrdí.");

        assertFalse(lokace1.maVychod(lokace2.getNazev()));
        assertFalse(lokace2.maVychod(lokace1.getNazev()));

        assertNull(lokace1.getVychod(lokace1.getNazev()));
        assertNull(lokace2.getVychod(lokace1.getNazev()));

        assertNotNull(lokace1.getVychody());
        assertTrue(lokace1.getVychody().isEmpty());

        assertNotNull(lokace2.getVychody());
        assertTrue(lokace2.getVychody().isEmpty());

        lokace1.pridejVychod(lokace2);
        lokace2.pridejVychod(lokace1);

        assertNotNull(lokace1.getVychody());
        assertEquals(1, lokace1.getVychody().size());

        assertNotNull(lokace2.getVychody());
        assertEquals(1, lokace2.getVychody().size());

        assertTrue(lokace1.maVychod(lokace2.getNazev()));
        assertTrue(lokace2.maVychod(lokace1.getNazev()));

        assertEquals(lokace2, lokace1.getVychod(lokace2.getNazev()));
        assertEquals(lokace1, lokace2.getVychod(lokace1.getNazev()));

        assertFalse(lokace1.maVychod("ucebna"));
        assertNull(lokace2.getVychod("ucebna"));


    }


    @Test
    public void najdiPredmetUspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        Predmet predmet1 = new Predmet("walkman", true, "Bude se někdo zlobit, když si ho nenápadně ukradnu?");
        lokace.addPredmet(predmet1);
        assertTrue(lokace.najdiPredmet("walkman"));
    }

    @Test
    public void najdiPredmetNeuspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        assertFalse(lokace.najdiPredmet("neco"));
    }

    @Test
    public void getVychodUspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        Lokace vychod1 = new Lokace("ulice", "Docela nebezpečná ulice u jednoho z nejznámějších klubů v New York City.");
        lokace.pridejVychod(vychod1);
        assertEquals(vychod1, lokace.getVychod("ulice"));
    }

    @Test
    public void getVychodNeUspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        assertNull(lokace.getVychod("neco"));
    }


    @Test
    public void maVychodUspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        Lokace vychod1 = new Lokace("ulice", "Docela nebezpečná ulice u jednoho z nejznámějších klubů v New York City.");
        lokace.pridejVychod(vychod1);
        assertTrue(lokace.maVychod("ulice"));
    }

    @Test
    public void maVychodNeUspech() {
        Lokace lokace = new Lokace("knihovna", "Najdou se tu starý zprávy.");
        assertFalse(lokace.maVychod("neco"));
    }


}