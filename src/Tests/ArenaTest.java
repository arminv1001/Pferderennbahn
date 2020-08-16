package Tests;

import Basis.Widerspruch;
import Reitsport.Pferd;
import Reitsport.Reiter;
import Reitsport.Reitpaar;
import Spielorg.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {
    Arena arena;
    @BeforeEach
    void setUp() {
        arena = new Arena("Halle", 100,50);
    }


    @Test
    void neuerBesucher() {
        arena.neuerBesucher();
        assertEquals(arena.getAktAnz(),1);
    }

    @Test
    void besucherVerlassen() {
        arena.neuerBesucher();
        arena.besucherVerlassen();
        assertEquals(arena.getAktAnz(),0);
    }


    @Test
    void besucherVerlassen2() {
        arena.besucherVerlassen();
        assert !arena.besucherVerlassen();
    }

    @Test
    void anmelden() throws Widerspruch {
        Reitpaar reitpaar = new Reitpaar(new Reiter("Name","Vorname",20,"Verein"), new Pferd("Name","Rasse","Verein"));
        reitpaar.anmeldenArena(arena);
        //Reitpaar[] reitpaars = arena.getOrga().getReitpaars();
       // assertEquals(reitpaars[0],reitpaar);
    }

    @Test
    void getName() {
        assertEquals(arena.getName(),"Halle");
    }

}