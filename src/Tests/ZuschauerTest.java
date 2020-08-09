/*
package Tests;

import Basis.Widerspruch;
import Besucher.Zuschauer;
import Reitsport.Pferd;
import Reitsport.Reiter;
import Reitsport.Reitpaar;
import Spielorg.Arena;
import Spielorg.BesucherAnzahl;

import static org.junit.jupiter.api.Assertions.*;

class ZuschauerTest {

    Zuschauer zuschauer;
    Arena arena;
    Reitpaar[] reitpaar;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Widerspruch {
        zuschauer = new Zuschauer("Mustermann","Max",20,100);
        arena = new Arena("Ölle", 100,10);
        reitpaar = new Reitpaar[5];
    }

    @org.junit.jupiter.api.Test
    void getKontostand() {
        assertEquals(100,zuschauer.getKontostand());
    }

    @org.junit.jupiter.api.Test
    void setKontostand() throws Widerspruch {
        zuschauer.setKontostand(20);
        assertEquals(zuschauer.getKontostand(),20);
    }

    @org.junit.jupiter.api.Test
    void setKontostand2() throws Widerspruch {
        try {
            zuschauer.setKontostand(-20);
        } catch (Widerspruch e){
            assert true;
        }
    }

    @org.junit.jupiter.api.Test
    void arenaBesuchen() {
        zuschauer.arenaBesuchen(arena);
        assertEquals(zuschauer.getStandort(),arena);
    }

    @org.junit.jupiter.api.Test
    void arenaVerlassen() throws Widerspruch {
        zuschauer.arenaBesuchen(arena);
        zuschauer.arenaVerlassen();
        assertNull(zuschauer.getStandort());
    }

    @org.junit.jupiter.api.Test
    void setWette() throws Widerspruch {
        for (int i = 0; i < reitpaar.length; i++){
            reitpaar[i] = new Reitpaar(new Reiter("ReiterName" + i, "ReiterVorname" + i, i,"Verein_"+ i), new Pferd("Pferd"+ i,"Rasse"+i,"Verein_"+ i));
            reitpaar[i].arenaAnmelden(arena);
        }
        zuschauer.arenaBesuchen(arena);
        arena.getOrga().erstelleSpielplan();
        zuschauer.setWette("Verein_1",20);
        assertEquals(zuschauer.getBeleg(0).getBelegNr(),1);
    }

    @org.junit.jupiter.api.Test
    void einloesen() throws Widerspruch {
        setWette();
        arena.getOrga().spieleSpielen();
        zuschauer.einloesen(0);
        try {
            zuschauer.getBeleg(0);
        }
        catch (IndexOutOfBoundsException e){
            assert true;
        }
        catch (NullPointerException e){
            assert true;
        }

    }

    @org.junit.jupiter.api.Test
    void getStandort() {
        assertNull(zuschauer.getStandort());
    }
}*/
