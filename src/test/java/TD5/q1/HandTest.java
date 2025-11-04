package TD5.q1;

import TD5.q1.api.ICard;
import TD5.q1.impl.Card;
import TD5.q1.impl.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Imports pour les assertions JUnit 5
import static TD5.q1.api.ICard.Rank.*;
import static TD5.q1.api.ICard.Suit.*;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    private Hand originalHand;
    private ICard cardA;
    private ICard cardB;
    private ICard cardC;

    // Cette méthode est exécutée avant CHAQUE test
    @BeforeEach
    void setUp() {
        // Crée une main originale
        originalHand = new Hand(10);

        // Crée quelques cartes
        cardA = new Card(ACE, SPADES);
        cardB = new Card(KING, HEARTS);
        cardC = new Card(QUEEN, DIAMONDS);

        // Ajoute deux cartes à la main originale
        originalHand.add(cardA);
        originalHand.add(cardB);
    }

    /**
     * Test 1: Vérifie l'indépendance du clone.
     * C'est le test le plus important : il vérifie que la liste
     * est bien copiée (deep copy de la collection).
     */
    @Test
    void testCloneIsIndependent() {
        // 1. ACTION: Cloner la main
        Hand clonedHand = originalHand.clone();

        // 2. VÉRIFICATION (Initiales)

        // Vérifie que ce ne sont pas les mêmes objets en mémoire
        assertNotSame(originalHand, clonedHand,
                "ERREUR: Le clone et l'original pointent vers le même objet !");

        // Vérifie que leur contenu est identique (via ta méthode equals)
        assertEquals(originalHand, clonedHand,
                "ERREUR: Le contenu du clone n'est pas égal à l'original.");

        // Vérifie que la taille est la même
        assertEquals(2, clonedHand.size(),
                "ERREUR: Le clone n'a pas la bonne taille (devrait être 2).");

        // 3. ACTION (Modification)
        // Ajoute une NOUVELLE carte UNIQUEMENT à la main ORIGINALE
        originalHand.add(cardC);

        // 4. VÉRIFICATION (Indépendance)

        // La taille de l'original doit être 3
        assertEquals(3, originalHand.size(),
                "ERREUR: L'original devrait avoir 3 cartes.");

        // La taille du clone doit TOUJOURS être 2
        assertEquals(2, clonedHand.size(),
                "ERREUR: Le clone a été modifié ! Sa taille a changé (devrait être 2).");

        // Le clone ne doit PAS contenir la carteC
        assertFalse(clonedHand.contains(cardC),
                "ERREUR: Le clone contient cardC, il n'est pas indépendant !");
    }

    /**
     * Test 2: Vérifie le partage des références des cartes.
     * C'est le test que tu as demandé : il vérifie que les cartes
     * à l'intérieur (immuables) sont les MÊMES instances.
     */
    @Test
    void testCloneSharesCardReferences() {
        // 1. ACTION: Cloner la main
        Hand clonedHand = originalHand.clone();

        // 2. RÉCUPÉRATION DES CARTES
        // On utilise les itérateurs pour récupérer les cartes.
        // NOTE: Ton itérateur trie les cartes. Pour simplifier,
        // on va juste vérifier la première carte retournée par l'itérateur trié.
        // (Tu devras adapter si 'rankComparator' n'est pas défini)

        ICard originalCard = originalHand.iterator().next();
        ICard clonedCard = clonedHand.iterator().next();

        // 3. VÉRIFICATION

        // On vérifie que la carte de l'original et la carte du clone
        // sont LE MÊME OBJET en mémoire.
        assertSame(originalCard, clonedCard,
                "ERREUR: Les cartes ne sont pas les mêmes instances. " +
                        "On s'attendait à ce qu'elles partagent la même référence.");

        // Note : Ce test peut échouer si ton itérateur n'est pas stable
        // ou si les 2 cartes (cardA, cardB) ont le même "rang"
        // pour le comparateur.

        // Une façon plus robuste de tester (si tu sais quelle carte vient en premier)
        // Disons que ACE (cardA) vient avant KING (cardB) dans ton tri :

        ICard firstOriginal = originalHand.iterator().next();
        ICard firstCloned = clonedHand.iterator().next();

        // Vérifie que la première carte (triée) dans les deux mains est 'cardA'
        // et que c'est la même instance.
        assertSame(cardA, firstOriginal, "La première carte de l'original n'est pas cardA.");
        assertSame(cardA, firstCloned, "La première carte du clone n'est pas cardA.");
    }
}