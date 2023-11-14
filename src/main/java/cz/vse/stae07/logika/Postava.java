package cz.vse.stae07.logika;

/**
 * Třída Postava - představuje postavu a její datové atributy a metody.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public abstract class Postava {
    protected boolean hracZnaJmeno;
    protected String jmenoNezname;
    protected String jmenoZname;
    protected String popis;


    /**
     * Tato metoda slouží k získání jména.
     * Pokud je jméno viditelné, vrátí se hodnota známého jména, jinak neznámého.
     *
     * @return jméno podle toho, zda ho známe nebo ne
     */
    public String getViditelneJmeno() {
        if (hracZnaJmeno) {
            return jmenoZname;
        }

        return jmenoNezname;
    }

    /**
     * Tato metoda slouží k přijetí předmětu.
     *
     * @param predmet, který mám v inventáři
     * @return reakce na předání předmětu
     */
    public String prijmiPredmet(Predmet predmet) {
        return "Díky. Sice nevim, proč mi to dáváš, ale darovanýmu koňovi na zuby nekoukej. Že?";
    }

    /**
     * Tato metoda slouží k přijetí úplatku.
     *
     * @param castka, kterou mám u sebe
     * @return reakce na předání peněz
     */
    public String prijmiUplatek(int castka) {
        return "Díky za peníze.";
    }


    /**
     * Tato metoda slouží k provádění akce "mluvit" s objektem. Každá konkrétní třída,
     * která implementuje toto rozhraní, musí poskytnout vlastní implementaci této metody.
     *
     * @return odpověď
     */
    public abstract String mluvit();


}
