import Basis.Systemfehler;
import Basis.Widerspruch;
import Besucher.Zuschauer;
import Reitsport.Pferd;
import Reitsport.Reiter;
import Reitsport.Reitpaar;
import Spielorg.Arena;
import Spielorg.BesucherAnzahl;


public class Main {
    public static void main(String[] args) throws Widerspruch, Systemfehler {
        Reiter reiter = new Reiter("Vosoghi", "Armin", 20, "UGfC");
        Reiter reiter1 = new Reiter("Hermann", "Kilian", 22, "UGC");
        Reiter reiter2 = new Reiter("Gebert", "Tim", 26, "UG");
        Reiter reiter3 = new Reiter("Freiheit", "Finn", 20, "GC");
        Reiter reiter4 = new Reiter("Nyghun", "Kim", 20, "UC");
        Arena a = new Arena("Iffesheim", 100, 10);
        Pferd pferd = new Pferd("Karl", "Esel", "UGfC");
        Pferd pferd1 = new Pferd("Ralle", "Esel", "UGC");
        Pferd pferd2 = new Pferd("Dölle", "Esel", "UG");
        Pferd pferd3 = new Pferd("Pöölle", "Esel", "GC");
        Pferd pferd4 = new Pferd("Böse", "Esel", "UC");
        Reitpaar reitpaar = new Reitpaar(reiter, pferd);
        Reitpaar reitpaar1 = new Reitpaar(reiter1, pferd1);
        Reitpaar reitpaar2 = new Reitpaar(reiter2, pferd2);
        Reitpaar reitpaar3 = new Reitpaar(reiter3, pferd3);
        Reitpaar reitpaar4 = new Reitpaar(reiter4, pferd4);


        reitpaar.anmeldenArena(a);
        reitpaar1.anmeldenArena(a);
        reitpaar2.anmeldenArena(a);
        reitpaar3.anmeldenArena(a);
        reitpaar4.anmeldenArena(a);
        a.erstelleSpieplan();

        //a.getOrga().getSpielplan().printSpielplan();
        Zuschauer zuschauer = new Zuschauer("Der", "Echte", 20, 100);
        Zuschauer zuschauer1 = new Zuschauer("Mayer", "Philip", 20, 300);
        Zuschauer zuschauer2 = new Zuschauer("Björn", "DerEchte", 34, 500);
        Zuschauer zuschauer3 = new Zuschauer("dulli", "Melle", 35, 1000);
        Zuschauer zuschauer4 = new Zuschauer("Jörk", "Lörik", 22, 520);
        Zuschauer zuschauer5 = new Zuschauer("Töri", "Böri", 90, 450);
        zuschauer.arenaBesuchen(a);
        zuschauer1.arenaBesuchen(a);
        zuschauer2.arenaBesuchen(a);
        zuschauer3.arenaBesuchen(a);
        zuschauer4.arenaBesuchen(a);
        zuschauer5.arenaBesuchen(a);
        zuschauer.setWette("UGC", 50);
        zuschauer1.setWette("UC", 10);
        zuschauer2.setWette("UGC", 50);
        zuschauer3.setWette("UGfC", 50);
        zuschauer4.setWette("UGC", 50);
        zuschauer5.setWette("GC", 50);
        zuschauer2.setWette("UGC", 50);
        a.spieleSpielen();
        zuschauer.einloesen(0);
        zuschauer1.einloesen(0);
        zuschauer2.einloesen(0);
        zuschauer3.einloesen(0);
        zuschauer4.einloesen(0);
        zuschauer5.einloesen(0);
        System.out.println("\nKonten der Zuschauer: ");
        System.out.print(zuschauer.getKontostand() + " | ");
        System.out.print(zuschauer1.getKontostand() + " | ");
        System.out.print(zuschauer2.getKontostand() + " | ");
        System.out.print(zuschauer3.getKontostand() + " | ");
        System.out.print(zuschauer4.getKontostand() + " | ");
        System.out.print(zuschauer5.getKontostand() + " | ");

    }
}
//TODO Ausgabe Runden Quoten
//TODO PLatzierung von 1 - 3