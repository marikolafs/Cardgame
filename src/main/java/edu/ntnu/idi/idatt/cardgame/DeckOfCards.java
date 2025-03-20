package edu.ntnu.idi.idatt.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The DeckOfcards class creates a deck of playing cards and retreives n amount
 * of random cards from the created deck.
 */
public class DeckOfCards {

  private List<PlayingCard> deck;
  private final char[] suit = {'S', 'H', 'D', 'C'};
  private final int[] face = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

  /**
   * Creates 13 cards of each suit and adds them to the deck.
   */
  public DeckOfCards() {
    deck = new ArrayList<>();
    for (char suit : suit) {
      for (int face : face) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Shuffles the cards in the deck and returns the first n cards from the list.
   *
   * @param n the number of cards to be drawn.
   * @return List of playing cards.
   */
  public List<PlayingCard> dealHand(int n) {
    Collections.shuffle(deck);
    return deck.subList(0, n);
  }
}
