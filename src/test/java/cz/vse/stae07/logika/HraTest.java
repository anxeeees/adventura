
package cz.vse.stae07.logika;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testovací třída slouží k otestování třídy Hra.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class HraTest {
    Hra hra;
    HerniSvet svet;


    public void setUp() {
        hra = new Hra();
        svet = hra.getHerniSvet();
    }


    @Test
    public void testSetUp() {
    }

    @Test
    void isHraSkoncilaUspech() {
        svet.setTvojeJmeno("bill");
        assertFalse(hra.isHraSkoncila());
        assertEquals("Haha! No to se ti povedlo. Geniální! Chvíli trvalo, než ti to došlo.\n" +
                "Ale chápu. Být psychicky labilní a myslet si, že děláš nějaký dobro... Drogy dělaj hodně. \n" +
                "Každopádně škoda, že jsi musel zabít toho novináře. Začínal se mi libit. Budu na tebe myslet, až budeš v lochu.", hra.zpracujPrikaz("oznac bill"));

        assertTrue(hra.isHraSkoncila());

    }

    private void assertFalse(boolean hraSkoncila) {
    }

    @Test
    void isHraSkoncilaNeuspech() {
        assertFalse(hra.isHraSkoncila());
        assertEquals("Holt ti to nevyšlo. Asi bych měl bejt lepší v nápovědách.\n" +
                "Chudák odsouzená osoba teď sedí v lochu, zatímco vrah si tu pořád někde lítá.\n" +
                "Jaká to smutná zpráva. Muhahah!!!", hra.zpracujPrikaz("oznac nekdo"));

        assertTrue(hra.isHraSkoncila());
    }

}
