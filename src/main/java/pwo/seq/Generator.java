package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Abstrakcyjna klasa Generator implementująca interfejs SequenceGenerator.
 * Zawiera wspólną logikę dla generatorów ciągów.
 * 
 * @author Kacper
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    // Zmienne do przechowywania stanu generatora
    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Resetuje generator do początkowego stanu.
     * Zeruje indeks ostatniego wyrazu.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Pobiera i-ty wyraz ciągu, generując wcześniej brakujące wyrazy, jeśli konieczne.
     * 
     * @param i Indeks wyrazu ciągu do pobrania.
     * @return i-ty wyraz ciągu w postaci BigDecimal.
     * @throws IllegalArgumentException jeśli indeks i jest mniejszy niż 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Indeks nie może być mniejszy niż 0.");
        }
        // Jeśli indeks i jest mniejszy niż ostatni indeks, resetuj generator
        if (i < lastIndex) {
            reset();
        }
        // Generuj wyrazy, aby osiągnąć żądany indeks
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
