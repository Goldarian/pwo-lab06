package pwo.seq;

import java.math.BigDecimal;

/**
 * Generator ciągu Lucasa rozszerzający klasę FibonacciGenerator.
 * Inicjalizuje początkowe wartości dla ciągu Lucasa.
 * Klasa ta implementuje logikę generowania kolejnych wyrazów ciągu Lucasa.
 * 
 * @author Kacper
 * @version 1.0.0
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor klasy LucasGenerator.
     * Inicjalizuje początkowe wartości dla ciągu Lucasa.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Resetuje generator do początkowego stanu.
     * Wywołuje również metodę reset z klasy nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Generuje kolejny wyraz ciągu Lucasa.
     * Metoda zawiera logikę generowania kolejnych wyrazów.
     * Pierwszy wyraz (dla lastIndex == 0) to 2, a następnie używa logiki
     * z klasy FibonacciGenerator.
     * 
     * @return Następny wyraz ciągu Lucasa w postaci BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
