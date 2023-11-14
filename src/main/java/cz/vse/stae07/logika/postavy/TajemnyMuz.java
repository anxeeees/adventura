package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.*;

/**
 * Třída TajemnyMuz - popisuje chovani tajemného muže.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class TajemnyMuz extends Postava {

    private boolean dostalCigateru;
    private boolean jeMrtvy;

    private Lokace podzemi;
    private Lokace klub;

    /**
     * Konstruktor třídy TajemnyMuz.
     * <p>
     * Nastavuje hodnoty datových atributů,
     * zda zná hráč jméno,
     * jméno před a po mluvení s postavou,
     * zda dostal cigaretu, je mrtvý, jeho polohu
     * a popis.
     *
     * @param klub,    kde se momentálně nachází
     * @param podzemi, kde se momentálně nachází
     */
    public TajemnyMuz(Lokace klub, Lokace podzemi) {
        this.hracZnaJmeno = false;
        this.jmenoZname = "Michael Stevenson";
        this.jmenoNezname = "Tajemny muz";
        this.popis = "novinar";
        dostalCigateru = false;
        this.jeMrtvy = false;
        this.klub = klub;
        this.podzemi = podzemi;

    }


    /**
     * Reakce tajemného muže, když se s ním snažíte promluvit.
     *
     * @return odpověď, podle toho, zda žije nebo ne
     */
    @Override
    public String mluvit() {
        if (jeMrtvy) {
            return "Do háje on umřel. Co teď budu dělat? Viděl někdo něco?";
        }

        if (dostalCigateru == false) {
            return "Tebe jsem tu ještě neviděl. Za poslední měsíc tu chodilo hodně divných lidí.\n" +
                    "Už to tu neni, co to tu bývalo. Prostituce za prostitucí... \n" +
                    "Pomalu se bojíš jít domu. Tohle město míří do hnoje.\n" +
                    "Řeknu ti, co vim, ale na tohle budu potřebovat pár cigaret.\n";
        }

        klub.odstranPostavu(this);
        podzemi.addPostava(this);
        return "Anna v podzemí by ti měla říct víc.";
    }

    /**
     * Reakce tajemného muže, když dostane předmět.
     *
     * @param predmet, který chce
     * @return odpověď po předání předmětu
     */
    public String prijmiPredmet(Predmet predmet) {
        if (predmet.getNazev().equals("cigareta")) {
            dostalCigateru = true;
            return "Uffff. Winstonky. Ty jsem dlouho neměl. Nuže. Malý ptáček zpíval, že" +
                    " osoba, kterou hledáš, je jistý fotograf.\nKdysi sem chodil často, ale od začátku" +
                    " vražd ho tu nikdo neviděl. Každopádně se motal na Fifth Avenue v den, kdy Fred zmizel.\n" +
                    "Náhoda? Nemyslím si. ";
        }
        return super.prijmiPredmet(predmet);

    }


    public void setJeMrtvy(boolean jeMrtvy) {
        this.jeMrtvy = jeMrtvy;
    }
}
