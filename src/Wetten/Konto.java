package Wetten;

import java.util.ArrayList;

/**
 * Pots der einzelnen Runden
 * @author armin
 */
public class Konto {
    private ArrayList<Double> konten;
    public Konto(){
        konten = new ArrayList<Double>();
    }
    public double get(int index){
        return  konten.get(index);
    }
    public int getSize(){
        return konten.size();
    }
    public void add(double d){
        konten.add(d);
    }
    public void set(int runde, double inhalt){
        konten.set(runde,inhalt);
    }

    /**
     * Es werden so viele Konten wie Runden erstellt
     * @param runden Anzahl der Runden
     */
    public void anzahlKontoRunden(int runden){
        for (int i = 0; i < runden ; i++) {
            konten.add(0.0);
        }
    }
}
