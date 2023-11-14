package cz.vse.stae07.logika.prikazy;

import java.util.List;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Inventar;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazZobrazitInventar - implementuje pro hru příkaz inventar.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazZobrazitInventar implements IPrikaz {
    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazZobrazitInventar(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    public String getNazev() {
        return "inventar";
    }

    /**
     * Zobrazí inventář.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        Inventar inventar = svet.getInventar();

        List<Predmet> predmety = inventar.getPredmety();

        StringBuilder popis = new StringBuilder("Peníze: $" + inventar.getPenize() + "\n");

        if (predmety.size() > 0) {
            popis.append("Máš předměty:\n");
            for (Predmet p : predmety) {
                popis.append("-" + p.getNazev() + "\n");
            }
        }

        return popis.toString();
    }
}
