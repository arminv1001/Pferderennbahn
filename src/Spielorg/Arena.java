package Spielorg;

import Basis.Widerspruch;
import Reitsport.Reitpaar;
import Wetten.Wettbuero;
/**
 * Klasse Arena, die Klasse Reitpaar kann sich hier anmelden für ein Turnier.
 * Der Zuschauer kann hier die Arena betreten, falls dort noch Platz ist oder fragen, wo das Wettbüro ist.
 * Von der Arena aus kann man auch das Tunier steuern.
 * @author armin
 */

public class Arena {
    private String name;
    private BesucherAnzahl besucherAnzahl;
    private final int MAX_REITPAARE;
    private Orga orga;
    private Wettbuero wettbuero;
    private double kasse;

    public Arena(String Name, int max_zuschauer, int max_reitpaare) {
        name = Name;
        besucherAnzahl = new BesucherAnzahl(max_zuschauer);
        MAX_REITPAARE = max_reitpaare;
        orga = new Orga(MAX_REITPAARE);
        wettbuero = orga.getWettbuero();
        kasse = 0;
    }

    public String getName() {
        return name;
    }

    /**
     * Neuer Besucher betritt die Arena
     * @return falls er noch reinpasst, wird true zurückgegeben
     */
    public boolean neuerBesucher() {
        if(besucherAnzahl.setAnzahlInc()) {
            kasse += 5;
            return  true;
        }
        else
            return false;
    }

    /**
     * Besucher verlässt die Arena
     * @return falls er nicht in der Arena ist, wird false zurückgegeben
     */
    public boolean besucherVerlassen() {
        return besucherAnzahl.setAnzahlDec();
    }

    public int getAktAnz() {
        return besucherAnzahl.getAnzahl();
    }

    /**
     * Reitpaar wird in der Orga angemeldet
     * @param reitpaar das Reitpaar das angemeldet werden soll
     */
    public void anmeldenReitpaar(Reitpaar reitpaar){
        orga.anmeldenReitpaar(reitpaar);
    }

    public void getSieger(){
        System.out.println(orga.getSpielverlauf().getSieger(0));
    }

    public Wettbuero getWettbuero(){
        return wettbuero;
    }

    public Spielplan getSpielplan(){
        return orga.getSpielplan();
    }


    /**
     * Dient nur zur Ansteuerung in der Main.
     * Erstellt einen Spieplan
     */
    public void erstelleSpieplan(){
        orga.erstelleSpielplan();
    }

    /**
     * Dient nur zur Ansteuerung in der Main.
     * Alle spiele der Arena werden gespielt
     * @throws Widerspruch Widerspruch
     */
    public void spieleSpielen() throws Widerspruch {
        orga.spieleSpielen();
    }
}
//TODO Arena Steuerung??