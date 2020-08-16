package Wetten;

import Basis.Systemfehler;
import Basis.Widerspruch;
import Besucher.Zuschauer;
import Reitsport.Reitpaar;
import Spielorg.Orga;
import Spielorg.Spielplan;

/**
 * Wettbuero; hier werden Wetten aufgelegt, eingelöst und verwaltet
 *
 * @author armin
 */
public class Wettbuero {
    private boolean spielplanErhalten;
    private WettListe wettListe;
    private final int MIN_ANZAHL_WETTEN;
    private WettID wettID;
    private Konto konto;
    private Quoten quoten;
    private  Orga orga;

    public Wettbuero(int MIN_ANZAHL_WETTEN, Orga orga) {
        this.orga = orga;
        konto = new Konto();
        wettListe = new WettListe();
        spielplanErhalten = false;

        this.MIN_ANZAHL_WETTEN = MIN_ANZAHL_WETTEN;
        wettID = new WettID();

    }

    public int getMIN_ANZAHL_WETTEN() {
        return MIN_ANZAHL_WETTEN;
    }

    /**
     * Falls öfters ein Spielplan aufgerufen wird, muss die Kontenliste angepasst werden
     *
     * @param spielplan1 Spielplan
     */
    public void setSpielplan(Spielplan spielplan1) {
        if (wettListe.getSize() <= 0) {
            konto.anzahlKontoRunden(orga.getSpielplan().getAnzahlRunden());
        } else if (konto.getSize() < spielplan1.getAnzahlRunden()) {
            for (int i = 0; i < spielplan1.getAnzahlRunden() - konto.getSize(); i++) {
                konto.add(0.0);
            }
        }
        spielplanErhalten = true;

    }

    /**
     * Erstellt Quoten in Abhängikeit von dem Gesamtpot und den einzelnen Pferden
     */
    private void erstelleQuoten() {
        Reitpaar[][] reitpaars = orga.getSpielplan().getSpieplan();
        quoten = new Quoten(reitpaars.length, reitpaars[0].length);
        quoten.erstelleQuoten(reitpaars, wettListe, konto);
    }

    /**
     * Erstellt einen Wettschein und wenn mehr als eine Wette gesetzt wurde, werden die ersten Quoten erstellt
     *
     * @param verein Verein vom Reitpaar
     * @param betrag Betrag der gewettet wird
     * @param zuschauer Zuschauer der wettet
     * @return  einen Beleg für den Kunden
     * @throws Widerspruch Fehler im System
     * @throws Systemfehler Systemfehler
     */
    public Beleg setWette(String verein, double betrag, Zuschauer zuschauer) throws Systemfehler, Widerspruch {
        if (spielplanErhalten) {
            Reitpaar reitpaar = orga.getSpielplan().findVerein(verein);
            if (reitpaar != null && !orga.getSpielplan().getDurchgespielt()) {
                int runde = orga.getSpielplan().getRunde(reitpaar);
                Wette wette = new Wette(zuschauer, reitpaar, betrag, wettID, runde);
                wettListe.add(wette);
                double tmp = konto.get(orga.getSpielplan().getRunde(reitpaar));
                tmp = tmp + betrag;
                konto.set(runde, tmp);
                if (wettListe.getSize() > 1) {
                    erstelleQuoten();
                    quoten.printQuoten();
                }
                return new Beleg(wette);
            } else {
                throw new Systemfehler("Fehler bei Wette");
            }
        }
        throw new Systemfehler("Der Spielplan fehlt");
    }

    /**
     * Gewinn im Verhältnis zu den gesetzen Wetten der Anderen
     *
     * @param beleg Beleg der Wette
     * @return Gewinn
     * @throws Widerspruch wirft eine Exception, wenn das Spiel noch nicht gestartet wurde
     */
    public double einloesenWette(Beleg beleg) throws Widerspruch {
        if (orga.getSpielverlauf() != null) {
            int posi = findWette(beleg);
            Reitpaar reitpaar = wettListe.get(posi).getReitpaar();
            if (reitpaar.equals(orga.getSpielverlauf().getSieger(orga.getSpielplan().getRunde(reitpaar))) && !wettListe.get(posi).getEingeloest()) {
                int arrayPosi = orga.getSpielplan().findeReitpaar(wettListe.get(posi).getReitpaar());
                wettListe.get(posi).setEingeloest();
                return quoten.getQuoten(wettListe.get(posi).getRunde(), arrayPosi) * wettListe.get(posi).getBetrag();
            } else {
                wettListe.get(posi).setEingeloest();
                return 0;
            }

        }
        throw new Widerspruch("Spiel wurde noch nicht gestartet");
    }


    /**
     * Sucht nach einer Wette in der ArrayListe anhand der ID
     *
     * @param beleg Beleg
     * @return Nummer für die WettListe
     * @throws Widerspruch wirft eine Exception, wenn die Wette nicht gefunden wurde
     */
    private int findWette(Beleg beleg) throws Widerspruch {
        for (int i = 0; i < wettListe.getSize(); i++) {
            if (beleg.getBelegNr() == wettListe.get(i).getId()) {
                return i;
            }
        }
        throw new Widerspruch("Fehler Wette wurde nicht gefunden");
    }

    public int getKontoSize(){
       return konto.getSize();
    }

}
