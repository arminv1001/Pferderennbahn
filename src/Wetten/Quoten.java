package Wetten;

import Reitsport.Reitpaar;
import java.util.Arrays;

/**
 * Quoten der einzelnen Pferde
 * @author armin
 */
public class Quoten {
    private double[][] quoten;

    /**
     * Konstruktor
     * @param runden Anzahl der Runden
     * @param MAX_PFERDE_RUNDEN MAX Pferde pro Runde
     * @inv Spieplan und Quoten müssen gleich viele Elemente haben
     */
    public Quoten(int runden, int MAX_PFERDE_RUNDEN) {
        quoten = new double[runden][MAX_PFERDE_RUNDEN];
    }

    /**
     * Erstellt die Quoten. Die Quoten ergeben sich aus dem Geld, das im Pot liegt und dem Geld, das auf das
     * jeweilige Reitpaar gesetzt wurde
     * @param reitpaars Spieplan
     * @param wettListe die Gesetzen Wetten
     * @param konto Pot
     * @pre Muss mehr als eine Wette vorliegen, damit Quoten erstellt werden
     */
    public void erstelleQuoten(Reitpaar[][] reitpaars, WettListe wettListe, Konto konto) {
        for (int i = 0; i < quoten.length; i++) {
            double[] betragReitpaar = new double[10];
            int j = -1;
            while (j < 10 && reitpaars[i][j + 1] != null) {
                j++;
                for (int g = 0; g < wettListe.getSize(); g++) {
                    if (reitpaars[i][j].getVerein().equals(wettListe.get(g).getReitpaar().getVerein())) {
                        betragReitpaar[j] = betragReitpaar[j] + wettListe.get(g).getBetrag();
                    }
                }
                if(betragReitpaar[j] == 0){
                    quoten[i][j] = 0;
                }
                else
                    quoten[i][j] = konto.get(i) / betragReitpaar[j];
            }
        }
    }

    /**
     * Quote für ein Reitpaar
     * @param runde Runde des Reitpaars
     * @param reitpaar Reitpaar
     * @return Quote
     */
    public double getQuoten(int runde, int reitpaar) {
        return quoten[runde][reitpaar];
    }

    public void setQuoten(int runde, int reitpaar, double quote) {
        quoten[runde][reitpaar] = quote;
    }
    public void printQuoten(){
        for(int i = 0; i < quoten.length ; i++){
            for(int j = 0; j < quoten[0].length; j++){
                System.out.print(String.format("%.2f",quoten[i][j])  + " | ");
            }
            System.out.println("\n");
        }
    }
}

