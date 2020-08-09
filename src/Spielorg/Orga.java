package Spielorg;

import Basis.Widerspruch;
import Reitsport.Reitpaar;
import Wetten.Wettbuero;

import java.util.Arrays;

/**
 * Organisation hinter der Arena
 *
 * @author armin
 */
public class Orga {

    private int aktReitpaarAnzahl;
    private Spielablauf spielverlauf = null;
    private Spielplan spielplan = null;
    private AnmeldeListe anmeldeListe;
    private Wettbuero wettbuero;

    public Orga(int MAX_REITPAARE) {

        anmeldeListe = new AnmeldeListe(MAX_REITPAARE);
        aktReitpaarAnzahl = 0;
        wettbuero = new Wettbuero(3,this);
    }

    /**
     * Ein Reitpaar meldet sich bei einer Arena an. Es darf von jedem Verein nur ein Paar antretten.
     *
     * @param reitpaar Reitpaar
     * @return Ob die anmeldung geklappt hat oder nicht
     */
    public boolean anmeldenReitpaar(Reitpaar reitpaar) {
        for (int i = 0; i < aktReitpaarAnzahl; i++) {
            if (reitpaar.getVerein().equals(anmeldeListe.getReitpaar(i).getVerein())) {
                return false;
            }
        }
        anmeldeListe.setReitpaar(aktReitpaarAnzahl,reitpaar);
        aktReitpaarAnzahl++;
        return true;
    }

    @Override
    public String toString() {
        return "Orga{" +
                "reitpaars=" + Arrays.toString(anmeldeListe.getReitpaars()) +
                '}';
    }

    /**
     * Erstellt einen Spielplan von der aktuellen Liste
     * und sendet es an das Wettbüro
     */
    public void erstelleSpielplan() {
        if (spielverlauf == null) {
            spielplan = new Spielplan(anmeldeListe, aktReitpaarAnzahl);
            wettbuero.setSpielplan(spielplan);
        }
    }

    /**
     * Spiel spielen
     */
    public void spieleSpielen() throws Widerspruch {
        if (spielplan != null && spielverlauf != null) {
            throw new Widerspruch("Spiel darf nur einmal gespielt werden");
        }
        if (spielplan == null) {
            if (aktReitpaarAnzahl >= 5)
                erstelleSpielplan();
            else
                System.out.println("Zu wenig Spieler");
            return;
        }
        spielverlauf = new Spielablauf(spielplan);
        spielplan.setDurchgepsielt();
    }

    public Spielablauf getSpielverlauf() {
        return spielverlauf;
    }

    public Spielplan getSpielplan() {
        return spielplan;
    }

    public Wettbuero getWettbuero() {
        return wettbuero;
    }
}
