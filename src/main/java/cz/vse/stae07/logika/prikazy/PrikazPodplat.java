package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Postava;
import cz.vse.stae07.logika.IPrikaz;

import java.util.Set;

/**
 * Třída PrikazPodplat - implementuje pro hru příkaz podplat.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazPodplat implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazPodplat(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "podplat";
    }

    /**
     * Provede podplacení postav.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();


        if (parametry.length == 0) {
            return "Kolik mám dát?";
        }

        if (parametry.length == 1) {
            return "Koho mám podplatit?";
        }

        int castka = 0;
        try {
            castka = Integer.parseInt(parametry[0].trim());
        } catch (NumberFormatException e) {
            return "Musíš zadat částku.";
        }


        if (castka > svet.getInventar().getPenize()) {
            //svet.getInventar().setPenize(svet.getInventar().getPenize() + castka);
            return "Tolik peněz nemám.";
        }

        String jmenoPostavy = "";
        for (int i = 1; i < parametry.length; i++) {
            jmenoPostavy += parametry[i] + " ";
        }
        jmenoPostavy = jmenoPostavy.trim();


            Postava postava = null;
        Set<Postava> postavy = svet.getAktualniLokace().getPostavy();
        for (Postava postavaVLokaci : postavy) {
            if (postavaVLokaci.getViditelneJmeno().equalsIgnoreCase(jmenoPostavy)) {
                postava = postavaVLokaci;
                break;
            }
        }

            if (postava == null) {
                return "Nikdo takový tady není.";
            }


        /*int penizeVInventari = svet.getInventar().getPenize();
        if (penizeVInventari >= castka) {
            svet.getInventar().setPenize(penizeVInventari - castka);
        } else {
            svet.getInventar().setPenize(penizeVInventari+castka);
            //castka =0;
        }
        return postava.prijmiUplatek(castka); */


            if (castka >= svet.getInventar().getPenize()) {
                svet.getInventar().setPenize(svet.getInventar().getPenize() - castka);
                return postava.prijmiUplatek(castka);
            } else {
                return "Tolik peněz nestačí na podplacení.";
            }
        }

    }


