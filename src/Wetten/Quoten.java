package Wetten;

import Reitsport.Reitpaar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Quoten der einzelnen Pferde
 */
public class Quoten {
    private double[][] quoten;

    public Quoten(int runden, int MAX_PFERDE_RUNDEN) {
        quoten = new double[runden][MAX_PFERDE_RUNDEN];
    }

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
                quoten[i][j] = konto.get(i) / betragReitpaar[j];
            }
        }
    }

    public double getQuoten(int runde, int reitpaar) {
        return quoten[runde][reitpaar];
    }

    public void setQuoten(int runde, int reitpaar, double quote) {
        quoten[runde][reitpaar] = quote;
    }
    public void printQuoten(){
        System.out.println(Arrays.deepToString(quoten));
    }
}

