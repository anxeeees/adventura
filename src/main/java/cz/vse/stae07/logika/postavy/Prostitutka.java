package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.logika.Postava;

/**
 * Třída Prostitutka - popisuje chování prostitutky.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Prostitutka extends Postava {

    private boolean bylPodplacenyPoprve;
    private boolean bylPodplacenyPodruhe;
    private HerniSvet svet;

    /**
     * Konstruktor třídy Prostitutka.
     * <p>
     * Nastavuje hodnoty datových atributů,
     * zda zná hráč jméno,
     * jméno před a po mluvení s postavou,
     * zda byla podplacená jednou nebo dvakrát a popis.
     */
    public Prostitutka(HerniSvet svet) {
        this.svet = svet;
        this.hracZnaJmeno = false;
        this.jmenoZname = "Anna";
        this.jmenoNezname = "Prostitutka";
        this.popis = "prostitutka. V puse ma cigaretu.";
        this.bylPodplacenyPoprve = false;
        this.bylPodplacenyPodruhe = false;

    }

    /**
     * Metoda pro podplacení Prostitutky.
     *
     * @param castka, kterou jí nabízím
     * @return různé odpovědi závislé na částce
     */
    @Override
    public String prijmiUplatek(int castka) {

        if (!bylPodplacenyPoprve) {
            if (castka < 150) {
                return "Hošánku. Já lidem dávám za 300, ale že jsi to ty, tak vezmu kldině i dvestěpáďo.";
            }

            bylPodplacenyPoprve = true;
            return svet.getTvojeJmeno() + ": Slyšel jsem o tobě dost hezkých věcí... Co měla znamenat ta hádka?" + "\nTaky tě zdravím. Hmmm... taky tu cejtíš mentol?" + "\nKaždopádně... Lupin mě má totiž hodně v lásce. V tu noc to bylo žhavý." + "\nByl tu totiž ten nechutnej hajzl. Pan fotograf. Prý měl s Fredem fotit nějaký akty." + "\nSamozřejmě, že mě to naštvalo. Když jsem se to dozvěděla, myslela jsem, že to nerozdýchám." + "\nNo a že u toho byl i ten básničkář? Vůbec ho neznám, ale s Fredem se potuloval taky." + "\nBůh ví, jestli v tom s panem úchylným fotografem nejedou spolu. Nosí u sebe nějaky fotky.";
        }
        if (!bylPodplacenyPodruhe) {
            if (castka < 250) {
                return "Informace, kterou ti teď předám, stojí víc, než pár usmrkaných korun.";
            }
            bylPodplacenyPodruhe = true;
            return "Běž na Park Avenue. Apartmán 155. Kód je X6.\n" + "Víc ti neřeknu.";
        }
        return "Díky za peníze, ale víc už ti neřeknu.";
    }


    /**
     * Reakce Prostitutky, když se s ní snažíte promluvit.
     *
     * @return odpověď podle toho, zda byla podplacena
     * a kolikrát
     */
    @Override
    public String mluvit() {
        this.hracZnaJmeno = true;
        if (!bylPodplacenyPoprve) {
            return "Zadarmo ti nic neřeknu.";
        }
        if (bylPodplacenyPoprve && !bylPodplacenyPodruhe) {
            return "Za víc peněz ti i víc řeknu, fešáku.";

        }
        return "To je všechno, co vím.";

    }


}
