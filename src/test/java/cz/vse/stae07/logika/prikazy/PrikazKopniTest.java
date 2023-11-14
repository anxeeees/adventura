package cz.vse.stae07.logika.prikazy;
import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Testovací třída slouží k otestování třídy PrikazKopni.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
class PrikazKopniTest {

    Hra hra;
    HerniSvet svet;
    @BeforeEach
    public void setUp() throws Exception {

        hra = new Hra();
        svet = hra.getHerniSvet();
    }

    @Test
    void provedNeuspech() {
        assertEquals("Do čeho mám kopnout?", hra.zpracujPrikaz("kopni"));
        assertEquals("Tento předmět se tady nenachází.", hra.zpracujPrikaz("kopni neco"));
        Lokace budka = new Lokace("budka", "budka s telefonem");
        Predmet telefon = new Predmet("telefon", false, "Hmmm. Stara vykopavka.");
        budka.addPredmet(telefon);
        svet.setAktualniLokace(budka);
        assertEquals("Nakopl jsi telefon, ale nic se nestalo.", hra.zpracujPrikaz("kopni telefon"));
    }

    @Test
    void provedUspechAProhra() {
        assertEquals("Do čeho mám kopnout?", hra.zpracujPrikaz("kopni"));
        assertEquals("Tento předmět se tady nenachází.", hra.zpracujPrikaz("kopni neco"));

        Lokace klub = new Lokace("klub", "Fuj tady to smrdí.");
        Predmet automat = new Predmet("automat", false, "Gambler ze mě nebude, ale třeba z toho" +
                " vypadnou nějaký prachy.");
        klub.addPredmet(automat);
        svet.setAktualniLokace(klub);
        assertEquals("Ty kráso. Padesát doláčů? To snad bude stačit.", hra.zpracujPrikaz("kopni automat"));
        assertEquals("Ty kráso. Padesát doláčů? To snad bude stačit.", hra.zpracujPrikaz("kopni automat"));
        assertEquals("Sakra, tak to jsem asi hodně podělal.", hra.zpracujPrikaz("kopni automat"));
    }
}