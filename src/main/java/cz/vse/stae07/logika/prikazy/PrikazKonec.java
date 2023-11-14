package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazKonec - implementuje pro hru příkaz konec.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazKonec implements IPrikaz {
    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, která má být příkazem konec ukončena
     */
    public PrikazKonec(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "konec";
    }

    /**
     * V případě, že hráč napíše příkaz konec, hra končí.
     *
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String proved(String[] parametry) {
        aktualniHra.setHraSkoncila(true);
        return "Díky, že sis zahrál(a).";
    }
}
