package edu.ntnu.idi.idatt.cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

  private List<PlayingCard> deck;
  private final char[] suit = { 'S', 'H', 'D', 'C' };
  private final int[] face = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

  public DeckOfCards() {
    deck = new ArrayList<>();
    for (char suit : suit) {
      for (int face : face) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  public List<PlayingCard> getDeck() {
    return deck;
  }

  /**
   * Blander kortene og henter de øverste n spillene.
   * @param n mengden kort som skal dras
   * @return liste med spill
   */
  public List<PlayingCard> dealHand(int n) {
    Collections.shuffle(deck);
    return deck.subList(0, n);
  }
}
