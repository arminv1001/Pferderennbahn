package Besucher;

import Wetten.Beleg;
import java.util.ArrayList;

/**
 * Belegliste, in der die Belege eines Zuschauers gespeichert werden
 * @author armin
 */
public class BelegListe {
    private ArrayList<Beleg> belegArrayList;

    public BelegListe() {
        belegArrayList = new ArrayList<Beleg>();
    }

    /**
     * Get Beleg
     * @param index Stelle des Beleges in der Liste
     * @return Beleg
     */
    public Beleg get(int index) {
        return belegArrayList.get(index);
    }

    /**
     * Beleg wird hinzugefügt
     * @param b Beleg der hinzugefügt werden soll
     */
    public void add(Beleg b) {
        belegArrayList.add(b);
    }

    /**
     * Aus der Liste wird ein Beleg an der Stelle index gelöscht
     * @param index welcher Beleg gelöscht werden soll
     */
    public void delete(int index){
        belegArrayList.remove(index);
    }
    public int getSize(){
        return belegArrayList.size();
    }
}
