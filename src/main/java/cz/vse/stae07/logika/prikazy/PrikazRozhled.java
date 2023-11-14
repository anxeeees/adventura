package cz.vse.stae07.logika.prikazy;

import java.util.Set;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.Postava;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazRozhled - implementuje pro hru příkaz rozhled.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazRozhled implements IPrikaz {
    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazRozhled(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "rozhled";
    }

    /**
     * Provede rozhled v lokaci a zobrazí, co se v lokaci nachází.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        Lokace lokace = svet.getAktualniLokace();


        Set<Postava> postavy = lokace.getPostavy();
        Set<Predmet> predmety = lokace.getPredmety();

        StringBuilder popisLokace = new StringBuilder("Aktuální lokace: " + lokace.getNazev() + "\n");
        if (postavy.size() > 0) {
            popisLokace.append("Někdo tu je: \n");
            for (Postava p : postavy) {
                popisLokace.append(p.getViditelneJmeno() + " " + "\n");
            }
        }

        if (predmety.size() > 0) {
            popisLokace.append("Viditelné předměty:\n");
            for (Predmet p : predmety) {
                popisLokace.append("-" + p.getNazev() + ": " + p.getPopis() + "\n");
            }
        }

        popisLokace.append("Sousední prostory:");
        for (Lokace sousedniLokace : svet.getAktualniLokace().getVychody()) {
            popisLokace.append(" " + sousedniLokace.getNazev() + " ");
        }


        return popisLokace.toString();
    }
}
