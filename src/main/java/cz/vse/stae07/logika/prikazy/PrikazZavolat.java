package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazZavolat - implementuje pro hru příkaz zavolej.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazZavolat implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazZavolat(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "zavolej";
    }


    /**
     * Provede zavolání.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        Lokace aktualniLokace = svet.getAktualniLokace();

        if (!aktualniLokace.najdiPredmet("telefon")) {
            return "Tady nemůžeš volat, není tu telefon.";
        }


        if (parametry.length == 0) {

            return "Kam mám zavolat?";
        }

        String telefonniCislo = parametry[0];

        if (telefonniCislo.equals("111232445")) {
            return "No konečně. To ti trvalo. Teď už jsi fakt blízko k odhalení vraha." +
                    "\nVrah je někdo, koho znáš, ale zároveň ne." +
                    "\nNěkdo, do koho bys to vůbec neřekl. MUHAHA!";
        }

        return "Toto telefonní číslo neexistuje.";

    }
}
