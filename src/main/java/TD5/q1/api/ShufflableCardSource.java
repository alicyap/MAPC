package TD5.q1.api;

/**
 * A card source that can be shuffled.
 */
public interface ShufflableCardSource extends CardSource {

    /**
     * Shuffles the cards.
     */
    void shuffle();
}
