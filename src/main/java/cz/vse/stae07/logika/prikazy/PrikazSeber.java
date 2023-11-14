package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.*;
import cz.vse.stae07.logika.IPrikaz;

import java.util.Set;

/**
 * Třída PrikazSeber - implementuje pro hru příkaz seber.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazSeber implements IPrikaz{
    private Hra aktualniHra;


    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazSeber(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "seber";
    }

    /**
     * Provede sebrání předmětu v lokaci, který je sebratelný.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        if (parametry.length == 0) {
            return "Co mám sebrat?";
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

        if (!predmet.getMuzeVzit()) {
            return "Tento předmět nelze sebrat.";
        }

        boolean jePredmetPridany = svet.getInventar().pridejPredmet(predmet);
        if (!jePredmetPridany) {
            return "Nemáš místo v  inventáři";
        }
        svet.getAktualniLokace().odstranPredmet(predmet);

        String text = "Přidal jsi " + predmet.getNazev() + " do inventáře.";

        if (predmet.getNazev().equals("zvykacky")) {
            Postava tajemnyMuz = null;
            Set<Postava> postavy = svet.getAktualniLokace().getPostavy();
            for (Postava p : postavy) {
                if (p.getViditelneJmeno().equalsIgnoreCase("Michael Stevenson") || p.getViditelneJmeno().equalsIgnoreCase("Tajemny muz")) {
                    tajemnyMuz = p;
                    break;
                }

            }
            if (tajemnyMuz != null) {
                text += "\nTyhle jsou dobrý, že?";
            }
        }

        return text;

    }
}
