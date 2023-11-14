package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.Postava;

/**
 * Třída ZvracenyFotograf - popisuje chování fotografa.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class ZvracenyFotograf extends Postava {
    public ZvracenyFotograf() {
        this.hracZnaJmeno = false;
        this.jmenoZname = "Charles Dahminger";
        this.jmenoNezname = "Fotograf";
        this.popis = "Fotograf";

    }

    /**
     * Reakce fotografa, když se s ním snažíte promluvit.
     *
     * @return odpověď
     */
    @Override
    public String mluvit() {
        this.hracZnaJmeno = true;
        return "Čekal jsem na tebe. Můžeš se pokochat mým nádherným uměním.\n" +
                "Mé nejhezčé umění bys byl ale ty. Tak krásný... hmmm. Něco na tobě je.\n" +
                "Tak zvrácený.\n";

    }
}
