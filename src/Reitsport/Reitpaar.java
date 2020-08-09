package Reitsport;

import Basis.Widerspruch;
import Spielorg.Arena;

import java.util.Objects;

/**
 * Pferd und Reiter werden hier zusammentreffen
 * @author armin
 */

public class Reitpaar {
    private Reiter reiter;
    private Pferd pferd;
    private String verein;
    public Reitpaar(Reiter R, Pferd P) throws Widerspruch {
        if(R == null || P == null){
            throw new Widerspruch("Kein Pferd oder Reiter enthalten");
        }
        else if(!R.getVerein().equals(P.getVerein())) {
            throw new Widerspruch("Sind nicht beide im gleichen Verein");
        }
        reiter = R;
        pferd = P;
        verein = reiter.getVerein();
    }

    public Reiter getReiter() {
        return reiter;
    }

    public Pferd getPferd() {
        return pferd;
    }

    /**
     *
    public boolean arenaAnmelden(Arena a) {
       return a.getOrga().anmeldenReitpaar(this);
    }*/

    public String getVerein() {
        return verein;
    }

    public boolean equals(Reitpaar reitpaar) {
        return reitpaar.getVerein().equals(verein);
    }
}
