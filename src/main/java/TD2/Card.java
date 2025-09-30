package TD2;

public class Card {

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER
    }

    public enum Suit {
        CLUBS, DIAMONDS, SPADES, HEARTS;

        public Color color() {
            return switch (this) {
                case DIAMONDS, HEARTS -> Color.RED;
                case CLUBS, SPADES -> Color.BLACK;
            };
        }
    }

    public enum GameDeck { ACE_CLUBS, TWO_CLUBS, THREE_CLUBS, FOUR_CLUBS, FIVE_CLUBS, SIX_CLUBS, SEVEN_CLUBS, EIGHT_CLUBS, NINE_CLUBS, TEN_CLUBS, JACK_CLUBS, QUEEN_CLUBS, KING_CLUBS,
        ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS, SIX_DIAMONDS, SEVEN_DIAMONDS, EIGHT_DIAMONDS, NINE_DIAMONDS, TEN_DIAMONDS, JACK_DIAMONDS, QUEEN_DIAMONDS, KING_DIAMONDS,
        ACE_SPADES, TWO_SPADES, THREE_SPADES, FOUR_SPADES, FIVE_SPADES, SIX_SPADES, SEVEN_SPADES, EIGHT_SPADES, NINE_SPADES, TEN_SPADES, JACK_SPADES, QUEEN_SPADES, KING_SPADES,
        ACE_HEARTS, TWO_HEARTS, THREE_HEARTS, FOUR_HEARTS, FIVE_HEARTS, SIX_HEARTS, SEVEN_HEARTS, EIGHT_HEARTS, NINE_HEARTS, TEN_HEARTS, JACK_HEARTS, QUEEN_HEARTS, KING_HEARTS,
        JOKER
    }

    public enum Color {
        RED, BLACK
    }

    private GameDeck gameDeck;
    private Rank rank;
    private Suit suit;

    /**
     * Creates a new card.
     * @param rank
     * @param suit
     * @pre rank != null && suit != null
     */
    public Card(Rank rank, Suit suit) {
        assert this.rank != null;
        assert this.suit != null;
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Suit of a card.
     * @return the suit of the card in line.
     */
    public Suit suit() {
        return Suit.values()[gameDeck.ordinal() / Rank.values().length];
    }

    /**
     * Rank of a card.
     * @return the rank of the card in columns.
     */
    public Rank rank() {
        return Rank.values()[gameDeck.ordinal() % Rank.values().length];
    }

    /**
     * Returns a string representation of this card.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
