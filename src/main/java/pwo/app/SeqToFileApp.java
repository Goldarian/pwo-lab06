package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Klasa SeqToFileApp reprezentująca aplikację wiersza poleceń do generowania ciągów
 * i zapisywania ich do plików.
 * 
 * @author Kacper
 * @version 1.0.0
 */
class SeqToFileApp {

    // Pola przechowujące argumenty aplikacji
    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    /**
     * Metoda pobierająca argumenty z linii poleceń.
     * Sprawdza poprawność argumentów i inicjalizuje pola aplikacji.
     * 
     * @param args Argumenty z linii poleceń.
     * @return true jeśli argumenty są poprawne, false w przeciwnym przypadku.
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            return false;
        }

        // Sprawdza poprawność ścieżki do pliku
        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        // Sprawdza, czy typ ciągu, 'from' i 'to' są ustawione poprawnie
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda zapisująca wygenerowany ciąg do pliku.
     * Wykorzystuje narzędzia z klasy SequenceTools.
     * 
     * @return true jeśli zapis do pliku powiódł się, false w przeciwnym przypadku.
     */
    protected boolean writeSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(), from, to, fileName);
    }

    /**
     * Metoda uruchamiająca aplikację.
     * Wyświetla informacje o aplikacji, pobiera i przetwarza argumenty, a następnie zapisuje wyniki do pliku.
     * 
     * @param args Argumenty z linii poleceń.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        // Pobiera i przetwarza argumenty
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to fileName");
            return;
        }

        // Zapisuje wyniki do pliku
        if (!writeSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
