package Besucher;

import Wetten.Beleg;

import java.util.ArrayList;

/**
 * Klass für die Belege
 *
 * @author armin
 */
public class BelegListe {
    private ArrayList<Beleg> belegArrayList;

    public BelegListe() {
        belegArrayList = new ArrayList<Beleg>();
    }

    public Beleg get(int index) {
        return belegArrayList.get(index);
    }

    public void add(Beleg b) {
        belegArrayList.add(b);
    }
    public void delete(int index){
        belegArrayList.remove(index);
    }
}
