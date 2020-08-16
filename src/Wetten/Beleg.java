package Wetten;

import Basis.Widerspruch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Klasse soll ein Beleg sein, welcher dem Zuschauer übergeben wird, mit dem er seine Wette einlösen kann.
 *
 * @author armin
 */
public class Beleg {

    private LocalDateTime localDateTime;
    private String belegID;
    private String eingabe;
    private int belegNr;

    public Beleg(Wette wette) {
        localDateTime = LocalDateTime.now();
        belegNr = wette.getId();
        belegID = belegNr + "_" + wette.getZuschauer().getStandort().getName() + "_" + wette.getZuschauer().getName() + ".txt";
        eingabe = "Vorname: " + wette.getZuschauer().getVorname() + "\n" + "Name: "
                + wette.getZuschauer().getName() + "\n"
                + "Verein: " + wette.getReitpaar().getVerein() + "\n"
                + "Uhrzeit: " + localDateTime.toString() + "\n"
                + "Betrag: " + wette.getBetrag() + "\n";
        createBeleg(belegID, eingabe);
    }

    /**
     * Erstellt einen Beleg
     *
     * @param belegID Filename
     * @param eingabe Fileinhalt
     */
    private void createBeleg(String belegID, String eingabe) {
        this.createBelegFile(belegID);
        this.writeInBeleg(eingabe, belegID);
    }

    /**
     * Erstellt das File
     *
     * @param belegName Filename
     */
    private void createBelegFile(String belegName) {
        try {
            File myObj = new File(belegName);
            if (myObj.createNewFile()) {
                System.out.println("Beleg wurde erstellt: " + myObj.getName());
                System.out.println("----------------------------------------");
            } else {
                throw new Widerspruch("File Exestiert");
            }
        } catch (IOException | Widerspruch e) {
            System.out.println("Fehler");
            e.printStackTrace();
        }
    }

    /**
     * Schreibt in das File
     *
     * @param eingabe Inhalt des Files
     * @param belegID Filename
     */
    private void writeInBeleg(String eingabe, String belegID) {
        try {
            FileWriter myWriter = new FileWriter(belegID);
            myWriter.write(eingabe);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Fehler");
            e.printStackTrace();
        }

    }

    public String getEingabe() {
        return eingabe;
    }

    public int getBelegNr() {
        return belegNr;
    }
}
