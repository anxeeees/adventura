package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazKoupit - implementuje pro hru příkaz kup.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazKoupit implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazKoupit(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "kup";
    }

    /**
     * Provede koupi předmětu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();

        if (parametry.length == 0) {
            return "Co mám koupit?";
        }

        String nazevPredmetu = parametry[0];

        for (Predmet predmet : svet.getAktualniLokace().getPredmety()) {
            if (predmet.getCena() == 0) {
                continue;
            }
            if (nazevPredmetu.equals(predmet.getNazev())) {
                int penize = svet.getInventar().getPenize();
                if (penize < predmet.getCena()) {
                    return "Na koupi " + nazevPredmetu + " nemáš dostatek peněz.";
                }
                boolean jePredmetPridany = svet.getInventar().pridejPredmet(predmet);
                if (!jePredmetPridany) {
                    return "Nemáš místo v  inventáři";
                }
                svet.getInventar().setPenize(penize - predmet.getCena());

                svet.getAktualniLokace().odstranPredmet(predmet);
                return "Koupil jsi " + nazevPredmetu;
            }
        }
        return "Tento předmět se tady nedá koupit.";
    }
}
