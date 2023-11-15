package pwo.utils;

import java.math.BigDecimal;

/**
* Interfejs dowolnego generatora liczbowego
* o wyrazach zdefiniowanych w zakresie od 0.
*
* @author Kacper
* @version 1.0.0
*/
public interface SequenceGenerator {

 /**
 * Powoduje, że metoda {@link #nextTerm()}
 * rozpoczyna od 0.<br>
 * Nie wpywan na działanie metody {@link #getTerm(int)}.
 */
    void reset();

 /**
 * Zwraca koleny wyraz ciągu.
 *
 * @return Wartość wyrazu ciągu
 * @see #getTerm(int)
 */
    BigDecimal nextTerm();

    BigDecimal getTerm(int i);
}
