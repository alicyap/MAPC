package TD3.api;

public interface IHand extends Iterable<ICard>, Comparable<IHand> {
    /**
     * Gets the maximum size of the hand.
     * @return the maximum size of the hand
     */
    int maxSize();

    /**
     * Adds a card to the hand.
     * @pre !isFull() && card != null
     */
    void add(ICard card);

    /**
     * Remove a card to the hand.
     * @pre !isFull() && contains(card)
     */
    void remove(ICard card);

    /**
     * Checks if the hand contains the given card.
     * @param card the card to check
     * @pre card != null
     */
    boolean contains(ICard card);

    /**
     * Gets the number of cards in the hand.
     */
    int size();

    default boolean isEmpty() {
        return size() == 0;
    };

    default boolean isFull() {;
        return size() == maxSize();
    };

    /**
     * Compares this hand to another one based on their sizes.
     */
    default int compareTo(IHand other) {
        return Integer.compare(this.size(), other.size());
    }
}
