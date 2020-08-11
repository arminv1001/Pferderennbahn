package Tests;

import Basis.Systemfehler;
import Basis.Widerspruch;
import Besucher.Zuschauer;
import Reitsport.Pferd;
import Reitsport.Reiter;
import Reitsport.Reitpaar;
import Spielorg.Arena;
import Wetten.Wettbuero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WettbueroTest {
    Wettbuero wettbuero;
    Arena arena;
    Reitpaar[] reitpaar;
    Zuschauer zuschauer1;
    Zuschauer zuschauer2;
    @BeforeEach
    void setUp() throws Widerspruch {
        arena = new Arena("Halle",100,10);

        reitpaar = new Reitpaar[5];

        for (int i = 0; i < reitpaar.length; i++){
            reitpaar[i] = new Reitpaar(new Reiter("ReiterName" + i, "ReiterVorname" + i, i,"Verein_"+ i), new Pferd("Pferd"+ i,"Rasse"+i,"Verein_"+ i));
            arena.anmeldenReitpaar(reitpaar[i]);
        }
        arena.erstelleSpieplan();
        zuschauer1 = new Zuschauer("Name1", "Vorname1",20,100);
        zuschauer2 = new Zuschauer("Name2", "Vorname2",25,400);
        zuschauer1.arenaBesuchen(arena);
        zuschauer2.arenaBesuchen(arena);
        wettbuero = arena.getWettbuero();
    }

    @Test
    void getMIN_ANZAHL_WETTEN() {
        assertEquals(wettbuero.getMIN_ANZAHL_WETTEN(), 3);
    }

    /**
     * Vorhandene Liste wird um 1 ergänzt Fehlerhaft
     */

    @Test
    void setSpielplan() {
        wettbuero.setSpielplan(arena.getSpielplan());
        assertEquals(arena.getWettbuero().getKontoSize(),2);
    }

    @Test
    void setWetteUndEinloesen() throws Widerspruch, Systemfehler {
        zuschauer1.setWette("Verein_1",10);
        zuschauer2.setWette("Verein_2",15);
        arena.spieleSpielen();
        zuschauer1.einloesen(0);
        try{
            zuschauer1.getBeleg(0);
        }
        catch (NullPointerException | IndexOutOfBoundsException e){
            assert true;
        }
    }
}
