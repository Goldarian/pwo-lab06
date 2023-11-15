package pwo.app;

/**
 * Klasa Sequence zawierająca metodę main.
 * Uruchamia aplikację SeqToFileApp, która zajmuje się generowaniem ciągów
 * i zapisywaniem ich do plików.
 * 
 * @author Kacper
 * @version 1.0.0
 */
public class Sequence {

    /**
     * Metoda main klasy Sequence.
     * Tworzy obiekt aplikacji SeqToFileApp i uruchamia ją, przekazując jej argumenty z linii poleceń.
     * 
     * @param args Argumenty z linii poleceń przekazywane do aplikacji SeqToFileApp.
     */
    public static void main(String[] args) {
        (new SeqToFileApp()).run(args);
    }
}
