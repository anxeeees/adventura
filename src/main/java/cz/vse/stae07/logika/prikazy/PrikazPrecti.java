package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazPrecti - implementuje pro hru příkaz precti.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazPrecti implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazPrecti(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "precti";
    }

    /**
     * Provede přečtení předmětu, který se dá číst.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        Lokace lokace = svet.getAktualniLokace();

        if (parametry.length < 1) {
            return "Nezadal jsi, co se má číst.";
        }

        String nazevPredmetu = parametry[0];
        if (!lokace.najdiPredmet(nazevPredmetu)) {
            return nazevPredmetu + " se v této lokaci nenachází.";
        }

        if (parametry[0].equals("papir")) {
            return " 17.6. - Sedim u baru. Přijde za mnou chlápek a po chvíli se probudim jinde.\n " +
                    "18.6. - Netušim, jak jsem to mohl přežít, ale nechal mě jít. Vybavuju si jeho vůni.\n " +
                    "19.6. - Fred zmizel. Každá stopa mě vede úplně jinam. Ztrácim naději.\n " +
                    "22.6. - Zase ta vůně. Vůně mentolu a cigaret. Je tu a je blíž než si myslíš.\n ";
        }


        if (parametry[0].equals("plakat")) {
            return "Hledá se: Fred Sinclair. \n" +
                    "Mladík ve věku 18 let, naposledy viděn 19.6. na Fifth Avenue. \n" +
                    "Za jakékoliv informace budete dobře odměněni.\n";
        }

        if (parametry[0].equals("fotografie1")) {
            return "Koukám, že se timhle asi chlubit nechtěl.";
        }

        if (parametry[0].equals("fotografie2")) {
            return "Frede, Frede... " +
                    "\nV knihovně najdeš odpovědi.";
        }

        if (parametry[0].equals("noviny1")) {
            return "Vraždy v New Yorku... Rok 1965. Ztratilo se kolem 20ti mužů.\n" +
                    "Všichni ve věku od 15ti do 25ti let. Sousedka zahlédla podezřelého " +
                    "s tím, že voněl jako mentol a cigarety.\n" +
                    "Autor: Michael Stevenson.\n";
        }

        if (parametry[0].equals("noviny2")) {
            return "Rok 1987. Byly nalezeny fotografie u oběti. Podezřelý rád píše básničky" +
                    "a rád fotí.\n" +
                    "Kolem oběti se našlo 20 obrázků. Vrátil se zpátky mentolový sériový vrah?\n" +
                    "Autor: Michael Stevenson.";
        }


        return "Na tomto předmětu není nic ke čtení.";
    }
}
