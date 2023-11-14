package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazNapoveda - implementuje pro hru příkaz napoveda.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazNapoveda implements IPrikaz {

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "napoveda";
    }

    /**
     * Vypíše nápovědu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        return "Jsi policajt v 80. letech a ve městě řádí vrah. Tvým úkolem je dopadnout správného vraha a pokusit se u toho " +
                "neumřít.\n" + "Můžeš zadat tyto příkazy: jdi, seber, dej, konec, napoveda, kopni, kup, mluv, odemkni" +
                ", podplat, poloz, precti, rozhled, seber, zapni, zavolej, inventar.\n" +
                "Vraha můžeš označit kdykoliv v průběhu hry, pokud si věříš.";


    }


}
