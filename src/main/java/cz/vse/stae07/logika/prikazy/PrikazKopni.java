package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.logika.IPrikaz;


/**
 * Třída PrikazKopni - implementuje pro hru příkaz kopni.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazKopni implements IPrikaz {


    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazKopni(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "kopni";
    }

    /**
     * Provede kopnutí do předmětu.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        if (parametry.length == 0) {
            return "Do čeho mám kopnout?";
        }

        String nazevPredmetu = parametry[0];

        Predmet predmet = null;
        for (Predmet predmetVLokalite : svet.getAktualniLokace().getPredmety()) {
            if (predmetVLokalite.getNazev().equals(nazevPredmetu)) {
                predmet = predmetVLokalite;
                break;
            }
        }


        if (predmet == null) {
            return "Tento předmět se tady nenachází.";
        }

        if (!predmet.getNazev().equals("automat")) {
            return "Nakopl jsi " + predmet.getNazev() + ", ale nic se nestalo.";
        }

        int penize = aktualniHra.getHerniSvet().getInventar().getPenize();
        svet.getInventar().setPenize(penize + 50);
        int pocetKopnutiDoAutomatu = svet.getPocetKopnutiDoAutomatu();
        pocetKopnutiDoAutomatu += 1;
        svet.setPocetKopnutiDoAutomatu(pocetKopnutiDoAutomatu);
        if (pocetKopnutiDoAutomatu > svet.getMAXIMALNI_POCET_KOPNUTI_DO_AUTOMATU()) {
            aktualniHra.setHraSkoncila(true);
            return "Sakra, tak to jsem asi hodně podělal.";
        }
        return "Ty kráso. Padesát doláčů? To snad bude stačit.";

    }
}
