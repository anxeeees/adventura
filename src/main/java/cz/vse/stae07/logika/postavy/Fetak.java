package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.Postava;

/**
 * Třída Fetak - popisuje chování feťáka.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Fetak extends Postava {

    /**
     * Konstruktor třídy Fetak.
     * <p>
     * Nastavuje hodnoty datových atributů,
     * zda zná hráč jméno,
     * jméno před a po mluvení s postavou
     * a popis.
     */
    public Fetak() {
        this.hracZnaJmeno = false;
        this.jmenoZname = "jezis";
        this.jmenoNezname = "Fetak";
        this.popis = "fetak";

    }

    /**
     * Reakce feťáka, když se s ním snažite promluvit.
     *
     * @return odpověď feťáka
     */
    @Override
    public String mluvit() {
        this.hracZnaJmeno = true;
        return "Vvvvv...rah. Viii...deee..l see....m";

    }


}
