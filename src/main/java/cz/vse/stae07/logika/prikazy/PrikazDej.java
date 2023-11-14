package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.*;

import java.util.Set;


/**
 * Třída PrikazDej - implementuje pro hru příkaz dej.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazDej implements IPrikaz {
    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazDej(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "dej";
    }


    /**
     * Provede výměnu předmětu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    //prvne predmet pak postava
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        if (parametry.length == 0) {
            return "Co mám jako předat?";
        }
        if (parametry.length == 1) {
            return "Komu to mám předat?";
        }

        String nazevPredmetu = parametry[0];
        String jmenoPostavy = "";
        for (int i = 1; i < parametry.length; i++) {
            jmenoPostavy += parametry[i] + " ";
        }
        jmenoPostavy = jmenoPostavy.trim();

        Predmet predmet = null;
        for (Predmet predmetVInventari : svet.getInventar().getPredmety()) {
            if (nazevPredmetu.equals(predmetVInventari.getNazev())) {
                predmet = predmetVInventari;
                break;
            }
        }
        if (predmet == null) {
            return "Tento předmět nemám v inventáři.";
        }

        Postava postava = null;
        Set<Postava> postavy = svet.getAktualniLokace().getPostavy();
        for (Postava postavaVLokaci : postavy) {
            if (postavaVLokaci.getViditelneJmeno().equalsIgnoreCase(jmenoPostavy)) {
                postava = postavaVLokaci;
                break;
            }
        }

        if (postava == null) {
            return "Nikdo takovej tu není.";
        }

        svet.getInventar().odeberPredmet(predmet);
        return postava.prijmiPredmet(predmet);

    }

}
