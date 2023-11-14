package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazOdemknout - implementuje pro hru příkaz odemkni.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazOdemknout implements IPrikaz {
    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazOdemknout(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "odemkni";
    }

    /**
     * Odemkne zamčenou lokaci.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();

        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Jakou lokaci mám odemknout?";
        }
        String jmenoLokace = parametry[0];

        if (parametry.length == 1) {
            // pokud chybí druhé slovo, tak ....
            return "Musíš k tomu zadat i kód.";
        }
        String kod = parametry[1];

        Lokace lokace = null;
        for (Lokace sousedniLokace : svet.getAktualniLokace().getVychody()) {
            if (sousedniLokace.getNazev().equals(jmenoLokace)) {
                lokace = sousedniLokace;
                break;
            }
        }

        if (lokace == null) {
            return "Toto není sousední lokace.";
        }

        if (lokace.isJePruchozi()) {
            return "Tato lokace je průchozí, není třeba ji odemykat.";
        }

        if (lokace.getNazev().equals("atelier") && kod.equals("X6")) {
            lokace.setJePruchozi(true);
            return "Ateliér je nyní odemčený.";
        }

        return lokace.getNazev() + " se ti nepovedla odemknout.";


    }
}
