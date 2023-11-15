package pwo.seq;

import java.math.BigDecimal;

/**
 * Generator ciągu Tribonacciego rozszerzający klasę FibonacciGenerator.
 * Inicjalizuje początkowe wartości dla ciągu Tribonacciego.
 * Klasa ta implementuje logikę generowania kolejnych wyrazów ciągu Tribonacciego.
 * 
 * @author Kacper
 * @version 1.0.0
 */
public class TribonacciGenerator extends FibonacciGenerator {

    /**
     * Konstruktor klasy TribonacciGenerator.
     * Inicjalizuje początkowe wartości dla ciągu Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Resetuje generator do początkowego stanu.
     * Wywołuje również metodę reset z klasy nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Generuje kolejny wyraz ciągu Tribonacciego.
     * Metoda zawiera logikę generowania kolejnych wyrazów.
     * 
     * @return Następny wyraz ciągu Tribonacciego w postaci BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
