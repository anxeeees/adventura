package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.Postava;

/**
 * Třída Snupin - popisuje chování Šňupina.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Snupin extends Postava {

    /**
     * Konstruktor třídy Snupin.
     * <p>
     * Nastavuje hodnoty datových atributů,
     * zda zná hráč jméno,
     * jméno před a po mluvení s postavou
     * a popis.
     */
    public Snupin() {
        this.hracZnaJmeno = false;
        this.jmenoZname = "Snupin";
        this.jmenoNezname = "Typek u baru v levo";
        this.popis = "barman";
    }


    /**
     * Reakce Šňupina, kdyz se s ním snažíte promluvit.
     *
     * @return odpověď
     */
    @Override
    public String mluvit() {
        this.hracZnaJmeno = true;
        return "Tohle je za tenhle tejden už třetí...\n" +
                "Nechápu, jak toho grázla ještě nikdo nenašel.";

    }
}
