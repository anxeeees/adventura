package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazJdi - implementuje pro hru příkaz jdi.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazJdi implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazJdi(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "jdi";
    }

    /**
     * Provede přechod do jiné loakce.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 1) { //osetreni vstupu, tohle delat u vseho!!!
            return "Tomu nerozumím, musíš mi říct, kam mám jít.";
        }

        if (parametry.length > 1) {
            return "Neumím dělat 150 věcí najednou.";
        }


        String nazevCiloveLokace = parametry[0];
        HerniSvet svet = aktualniHra.getHerniSvet();
        Lokace aktualniLokace = svet.getAktualniLokace();

        svet.setPocetKopnutiDoAutomatu(0);
        Lokace cilovaLokace = aktualniLokace.getVychod(nazevCiloveLokace);

        if (!aktualniLokace.maVychod(nazevCiloveLokace) && nazevCiloveLokace != null) {
            return "Sem se jít nedá";
        } else if (!cilovaLokace.isJePruchozi()) {
            return "Dveře jsou zamčené. Asi to chce nějakej kód.";
        } else if
        (cilovaLokace.getNazev().equals("klub") && aktualniLokace.getNazev().equals("podzemi")) {
            svet.getTajemnyMuz().setJeMrtvy(true);
        }



        svet.setAktualniLokace(cilovaLokace);

        StringBuilder popisLokace = new StringBuilder("Odešel jsi do lokace ..." + cilovaLokace.getNazev() + ".\n");
        popisLokace.append(cilovaLokace.getPopis());


        return popisLokace.toString();


    }


}
