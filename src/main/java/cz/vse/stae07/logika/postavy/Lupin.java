package cz.vse.stae07.logika.postavy;

import cz.vse.stae07.logika.Postava;
import cz.vse.stae07.logika.Predmet;

/**
 * Třída Lupin - popisuje chovani Lupina.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Lupin extends Postava {
    private boolean bylPodplacenyPoprve;
    private boolean bylPodplacenyPodruhe;

    /**
     * Konstruktor třídy Lupin.
     * <p>
     * Nastavuje hodnoty datových atributů,
     * zda zná hráč jméno,
     * jméno před a po mluvení s postavou,
     * zda byl podplacený jednou nebo dvakrát a popis.
     */
    public Lupin() {
        this.hracZnaJmeno = false;
        this.jmenoZname = "Lupin";
        this.jmenoNezname = "Typek u baru v pravo";
        this.popis = "barman";
        this.bylPodplacenyPoprve = false;
        this.bylPodplacenyPodruhe = false;

    }

    /**
     * Metoda pro podplacení Lupina.
     *
     * @param castka, kterou mu nabízím
     * @return různé odpovědi závislé na částce
     */
    @Override
    public String prijmiUplatek(int castka) {
        if (castka < 50) {
            return "Hmmm. To je málo, přitlač.";
        }
        if (!bylPodplacenyPoprve) {
            bylPodplacenyPoprve = true;
            return "Támhleten týpek v klubu... Jo támhleten.\n" +
                    "Nějak moc tu šmejdí. Vždycky si tu vytáhne ty jeho spisy a noviny.\n" +
                    "Možná si tam píše další jeho oběti. S Fredem se celkem bavili. Ne celkem, ale dost.\n";
        }
        if (!bylPodplacenyPodruhe) {
            bylPodplacenyPodruhe = true;
            return "Podle mě v tom má prsty i ta prostitutka, se kterou se zná.\n" +
                    "Prý byla do Freda trošku zakoukaná, ale on ji nikdy nechtěl. Linie mezi láskou a nenávistí\n" +
                    "je doopravdy tenká. Jednou se tu zhádali všichni 3. Musel jsem je vyhodit. Vlastně to bylo pár dní \n" +
                    "předtim, než Fred zmizel nadobro.\n" +
                    "Jestli si chceš promluvit s prostitutkou, pohybuje se dole v bordelu.\n";
        }
        return "Díky za prachy, ale víc už ti neřeknu.";
    }


    /**
     * Reakce Lupina, když se s ním snažíte promluvit.
     *
     * @return odpověď podle toho, zda byl podplacen
     * a kolikrát
     */
    @Override
    public String mluvit() {
        this.hracZnaJmeno = true;
        if (!bylPodplacenyPoprve) {
            return "Zadarmo ti nic neřeknu.";
        }
        if (bylPodplacenyPoprve && !bylPodplacenyPodruhe) {
            return "Kdybys přidal, řeknu ti víc.";

        }
        return "Tak to je všechno, co vim. Víc, ti neřeknu kápo.";

    }

}
