package Wetten;

import java.util.ArrayList;

/**
 * Liste für die Wetten
 */
public class WettListe {
    private ArrayList<Wette> wettListe;
    public WettListe(){
        wettListe = new ArrayList<Wette>();
    }

    public Wette get(int index) {
        return wettListe.get(index);
    }

    public void setWettListe(int index, Wette inhalt) {
        wettListe.set(index,inhalt);
    }

    public int getSize(){
        return wettListe.size();
    }

    public void add(Wette w){
        wettListe.add(w);
    }

    public ArrayList<Wette> getWettListe() {
        return wettListe;
    }
}
