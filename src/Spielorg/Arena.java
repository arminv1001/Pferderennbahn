package Spielorg;

import Basis.Systemfehler;
import Basis.Widerspruch;
import Reitsport.Reitpaar;
import Wetten.Wettbuero;

public class Arena {
    private String name;
    private BesucherAnzahl besucherAnzahl;
    private final int MAX_REITPAARE;
    private Orga orga;
    private Wettbuero wettbuero;
    private static int id = 0;

    public Arena(String Name, int max_zuschauer, int max_reitpaare) {
        name = Name;
        besucherAnzahl = new BesucherAnzahl(max_zuschauer);
        MAX_REITPAARE = max_reitpaare;
        id++;
        orga = new Orga(MAX_REITPAARE);
        wettbuero = orga.getWettbuero();
    }

    public String getName() {
        return name;
    }

    public boolean neuerBesucher() {
        return besucherAnzahl.setAnzahlInc();
    }

    public boolean besucherVerlassen() {
        return besucherAnzahl.setAnzahlDec();
    }

    public int getAktAnz() {
        return besucherAnzahl.getAnzahl();
    }

    public void anmeldenReitpaar(Reitpaar reitpaar){
        orga.anmeldenReitpaar(reitpaar);
    }

    public void erstelleSpieplan(){
        orga.erstelleSpielplan();
    }

    public void spieleSpielen() throws Widerspruch {
        orga.spieleSpielen();
    }

    public void getSieger(){
        System.out.println(orga.getSpielverlauf().getSieger(0));
    }

    public Wettbuero getWettbuero(){
        return wettbuero;
    }

}
//TODO Arena Steuerung??