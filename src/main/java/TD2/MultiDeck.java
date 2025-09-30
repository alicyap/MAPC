package TD2;

import java.util.ArrayList;
import java.util.List;

public class MultiDeck {
    private List<Deck> decks;

    public MultiDeck(int nbDecks) {
        assert nbDecks > 0;
        this.decks = new ArrayList<>(nbDecks);
        for (int i = 0; i < nbDecks; i++) {
            this.decks.add(new Deck());
        }
    }

    public MultiDeck(MultiDeck multiDeck) {
        // copie pas assez profonde pas le mieux
        // this.decks = new ArrayList<>(multiDeck.decks);
        // les decks sont copiés mais pas les cartes à l'intérieur
        this.decks = new ArrayList<>();
        for (Deck deck : multiDeck.decks) {
            this.decks.add(new Deck(deck));
            // crée une copie de chaque deck = copie profonde
        }
    }

    public Card draw() {
        assert taille() > 0;
        return decks.stream().filter(d -> d.size() > 0).findFirst().get().draw();
    }

    public int taille() {
        return decks.stream().mapToInt(Deck::size).sum();
    }

    public List<Card> afficherCartes() {
        return decks.stream().flatMap(d -> d.cards.stream()).toList();

    }

    @Override
    public String toString() {
        return " I am a deck with " + taille() + " cards :\n";
    }

}
