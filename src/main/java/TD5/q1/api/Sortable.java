package TD5.q1.api;

import java.util.Comparator;

/**
 * Anything that can be sorted.
 */
public interface Sortable<T> {

    /**
     * Sort the collection using a Comparator.
     * @param comparator the comparator to use
     */
    void sort(Comparator<T> comparator);
}
