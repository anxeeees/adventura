package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Testovací třída slouží k otestování třídy PrikazZapni.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazZapniTest {

    Hra hra;
    HerniSvet svet;

    @BeforeEach
    public void setUp() throws Exception {

        hra = new Hra();
        svet = hra.getHerniSvet();
    }

    @Test
    public void provedPrikazZapniNeuspech() {
        assertEquals("Co mám zapnout?", hra.zpracujPrikaz("zapni"));
        assertEquals("Tento předmět se tady nenachází.", hra.zpracujPrikaz("zapni radio"));

        Lokace budka = new Lokace("budka", "budka s telefonem");
        Predmet telefon = new Predmet("telefon", false, "Hmmm. Stara vykopavka.");
        budka.addPredmet(telefon);
        svet.setAktualniLokace(budka);
        assertEquals("Tento předmět se nedá zapnout.", hra.zpracujPrikaz("zapni telefon"));


    }

    @Test
    public void provedPrikazZapniUspech() {
        Lokace atelier = new Lokace("atelier", "Takze tady bydli ten podivin.");
        Predmet radio = new Predmet("radio", false, "Tak copak tam mame?");
        atelier.addPredmet(radio);
        svet.setAktualniLokace(atelier);
        assertEquals("Divný šum z rádia... \n" +
                "Vrah je tak blízko ... \n" +
                "Šum... \n" +
                "jedna...jedna...jedna...\n" +
                "dva...tři...dva...\n" +
                "čtyři...čtyři...pět...\n" +
                "Za...vo....lej...", hra.zpracujPrikaz("zapni radio"));


    }


}
