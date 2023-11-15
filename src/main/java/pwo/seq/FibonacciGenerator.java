package pwo.seq;

import java.math.BigDecimal;

/**
 * Generator ciągu Fibonacciego rozszerzający klasę abstrakcyjną Generator.
 * Inicjalizuje początkowe wartości dla ciągu Fibonacciego.
 * Klasa ta implementuje logikę generowania kolejnych wyrazów ciągu.
 * 
 * @author Kacper
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor klasy FibonacciGenerator.
     * Inicjalizuje początkowe wartości dla ciągu Fibonacciego.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Resetuje generator do początkowego stanu.
     * Wywołuje również metodę reset z klasy nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Generuje kolejny wyraz ciągu Fibonacciego.
     * Metoda zawiera logikę generowania kolejnych wyrazów.
     * 
     * @return Następny wyraz ciągu Fibonacciego w postaci BigDecimal.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
