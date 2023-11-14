package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazPoloz - implementuje pro hru příkaz poloz.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazPoloz implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazPoloz(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "poloz";
    }

    /**
     * Provede položení předmětu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        if (parametry.length == 0) {
            return "Co mám položit?";
        }

        String nazevPredmetu = parametry[0];

        Predmet predmet = null;
        for (Predmet predmetVInventari : svet.getInventar().getPredmety()) {
            if (nazevPredmetu.equals(predmetVInventari.getNazev())) {
                predmet = predmetVInventari;
                break;
            }
        }
        if (predmet == null) {
            return "Tento předmět nemáš v inventáři.";
        }

        svet.getAktualniLokace().addPredmet(predmet);
        svet.getInventar().odeberPredmet(predmet);
        return "Položil jsi " + predmet.getNazev();

    }
}
