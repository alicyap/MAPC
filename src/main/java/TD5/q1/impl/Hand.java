package TD5.q1.impl;

import TD5.q1.api.ICard;
import TD5.q1.api.IHand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// ÉTAPE 1: Ajout de "implements Cloneable"
public class Hand implements IHand, Cloneable {
    private int maxCards;
    private Collection<ICard> cards;

    public Hand(int maxCards){
        this.maxCards = maxCards;
        this.cards = new ArrayList<>();

    }

    //Crée une main avec des cartes
    public Hand(IHand hand){
        this.maxCards = hand.maxSize();
        this.cards = new ArrayList<>();
        for(ICard card : hand){
            this.cards.add(card);
        }
    }

    @Override
    public int maxSize() {
        return maxCards;
    }

    @Override
    public void add(ICard card) {
        assert(card != null);
        assert(!isFull());
        cards.add(card);
    }

    @Override
    public void remove(ICard card) {
        assert(card != null);
        assert(cards.contains(card));
        cards.remove(card);
    }

    @Override
    public boolean contains(ICard card) {
        assert(card != null);
        return cards.contains(card);
    }

    @Override
    public int size() {
        // CORRECTION : Ta méthode retournait 0, je l'ai corrigée.
        return cards.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(ICard card : cards){ // ou this car IHand est iterable
            sb.append(card.toString()).append(", ");
        }
        return sb.toString();
    }

    public String toString2(){
        return cards.stream()
                .map(ICard::toString)
                .collect(Collectors.joining(", ")); // joining = foldLeft en Java
    }

    @Override
    public Iterator<ICard> iterator() {
        // version simple
        /* return cards.iterator(); */

        // pour ne pas modifier l'ordre interne mais
        // ne marche que si on modifie la main après l'appel
        List<ICard> copy = new ArrayList<>(cards);
        copy.sort(ICard.rankComparator());
        return copy.iterator();

        // sinon classe anonyme (plus verbeux)
        /* return new Iterator<ICard>() {
            private Iterator<ICard> it = cards.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public ICard next() {
                return it.next();
            }
         */
    }

    @Override
    public int compareTo(IHand other) {
        return Integer.compare(this.size(), other.size());
    }
    // deux mains sont égales si elles ont les mêmes cartes
    // (même taille et même cartes, ordre non important)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IHand)) return false;
        IHand other = (IHand) o;
        if (this.size() != other.size()) return false;
        for (ICard card : this) {
            if (!other.contains(card)) return false;
        }
        return true;
    }

    // hashCode doit être compatible avec equals
    // (même cartes => même hashCode)
    // pas forcément l'inverse (même hashCode => même cartes)
    @Override
    public int hashCode() {
        int hash = 7;
        for (ICard card : this) {
            hash = 31 * hash + card.hashCode();
        }
        return hash;
    }

    // ÉTAPE 2: Ajout de la méthode clone()
    @Override
    public Hand clone() {
        try {
            // 1. Appelle super.clone() pour copier les champs primitifs (maxCards)
            //    et obtenir une nouvelle instance de Hand.
            Hand clonedHand = (Hand) super.clone();

            // 2. Gérer la copie profonde : créer une *nouvelle* collection
            //    pour le clone, contenant les mêmes cartes.
            clonedHand.cards = new ArrayList<>();
            for (ICard card : this.cards) {
                // Les cartes sont immuables, on peut donc partager les références.
                clonedHand.add(card);
            }

            return clonedHand;

        } catch (CloneNotSupportedException e) {
            // Ne devrait jamais arriver car on implémente Cloneable
            throw new AssertionError(); // Indique une erreur interne
        }
    }
}