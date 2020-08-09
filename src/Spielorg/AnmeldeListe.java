package Spielorg;

import Reitsport.Reitpaar;

public class AnmeldeListe {
    private Reitpaar[] reitpaars;
    public AnmeldeListe(int MAX_REITPAARE){
        reitpaars = new Reitpaar[MAX_REITPAARE];
    }
    public Reitpaar getReitpaar(int index){
        return reitpaars[index];
    }
    public void setReitpaar(int index, Reitpaar inhalt){
        reitpaars[index] = inhalt;
    }

    public int getLength(){
        return reitpaars.length;
    }

    public Reitpaar[] getReitpaars() {
        return reitpaars;
    }

}
