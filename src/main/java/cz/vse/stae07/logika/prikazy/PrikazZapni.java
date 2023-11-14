package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.*;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazZapni - implementuje pro hru příkaz zapni.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazZapni implements IPrikaz {

    private Hra aktualniHra;


    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazZapni(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "zapni";
    }

    /**
     * Provede zapnutí předmětu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();

        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mám zapnout?";
        }

        String nazevPredmetu = parametry[0];

        Predmet predmet = null;
        for (Predmet predmetVLokalite : svet.getAktualniLokace().getPredmety()) {
            if (predmetVLokalite.getNazev().equals(nazevPredmetu)) {
                predmet = predmetVLokalite;
                break;
            }
        }
        if (predmet == null) {
            return "Tento předmět se tady nenachází.";
        }

        if (predmet.getNazev().equals("radio")) {
            return "Divný šum z rádia... \n" +
                    "Vrah je tak blízko ... \n" +
                    "Šum... \n" +
                    "jedna...jedna...jedna...\n" +
                    "dva...tři...dva...\n" +
                    "čtyři...čtyři...pět...\n" +
                    "Za...vo....lej..."
                    ;


        }
        if (predmet.getNazev().equals("walkman")) {
            return "Queens? Někdo tu má dobrej hudební vkus.";
        }

        return "Tento předmět se nedá zapnout.";


    }


}

