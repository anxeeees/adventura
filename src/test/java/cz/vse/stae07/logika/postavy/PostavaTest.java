package cz.vse.stae07.logika.postavy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testovací třída slouží k otestování postavy.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
class PostavaTest {

    private Lupin lupin;

    @BeforeEach
    public void setUp() {
        lupin = new Lupin();
    }

    @Test
    void mluvitAprijmiUplatek() {
        assertEquals("Zadarmo ti nic neřeknu.", lupin.mluvit());

        assertEquals("Hmmm. To je málo, přitlač.", lupin.prijmiUplatek(49));

        assertEquals("Támhleten týpek v klubu... Jo támhleten.\n" +
                "Nějak moc tu šmejdí. Vždycky si tu vytáhne ty jeho spisy a noviny.\n" +
                "Možná si tam píše další jeho oběti. S Fredem se celkem bavili. Ne celkem, ale dost.\n", lupin.prijmiUplatek(50));


        assertEquals("Kdybys přidal, řeknu ti víc.", lupin.mluvit());


        assertEquals("Podle mě v tom má prsty i ta prostitutka, se kterou se zná.\n" +
                "Prý byla do Freda trošku zakoukaná, ale on ji nikdy nechtěl. Linie mezi láskou a nenávistí\n" +
                "je doopravdy tenká. Jednou se tu zhádali všichni 3. Musel jsem je vyhodit. Vlastně to bylo pár dní \n" +
                "předtim, než Fred zmizel nadobro.\n" +
                "Jestli si chceš promluvit s prostitutkou, pohybuje se dole v bordelu.\n", lupin.prijmiUplatek(50));


        assertEquals("Tak to je všechno, co vim. Víc, ti neřeknu kápo.", lupin.mluvit());
    }
}