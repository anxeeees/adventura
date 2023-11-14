package cz.vse.stae07.logika.prikazy;

import java.util.Set;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Postava;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazMluvit - implementuje pro hru příkaz mluv.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazMluvit implements IPrikaz {


    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazMluvit(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "mluv";
    }

    /**
     * Provede mluvení k postavě.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        String jmenoPostavy = String.join(" ", parametry);

        if (parametry.length == 0) {
            return "Na koho mám mluvit?";
        }

        Set<Postava> postavy = svet.getAktualniLokace().getPostavy();
        for (Postava p : postavy) {
            if (p.getViditelneJmeno().equalsIgnoreCase(jmenoPostavy)) {
                return p.mluvit();
            }


        }

        return "Nikdo takový tady není.";


    }


}
