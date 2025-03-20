package edu.ntnu.idi.idatt.cardgame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages the cards in the hand and makes checks for flush, the queen of spades,
 * the sum of faces and the heart cards in the hand.
 */
public class Hand {

  private List<PlayingCard> hand;

  /**
   * Creates an instance of the hand.
   *
   * @param hand List of cards in the hand.
   */
  public Hand(List<PlayingCard> hand) {
    this.hand = hand;
  }

  /**
   * Counts the number of each suit in the hand and checks if any suit has 5 or more cards.
   *
   * @return true/false whether or not 5 cards of the same suit exist in the hand.
   */
  public boolean flush() {
    Map<Character, Long> suitCount = hand.stream().collect(
        Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));
    return suitCount.containsValue(5L);
  }

  /**
   * Adds together the sum of the faces on the cards in the hand.
   *
   * @return int sum of faces in hand.
   */
  public int cardSum() {
    return hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Looks for heart cards in the hand and returns a string with all hearts found.
   *
   * @return String List of heart cards in the hand.
   */
  public String hearts() {
    return hand.stream().filter(card -> card.getSuit() == 'H').map(PlayingCard::getAsString)
        .collect(
            Collectors.joining(" ", "Heart cards: ", ""));
  }

  /**
   * Checks the hand for the queen of spades, S12 and returns true if it is found.
   *
   * @return true/false Whether the queen of spades exists in the hand.
   */
  public boolean queenOfSpades() {
    boolean queenOfSpades;
    if (getCards().contains("S12")) {
      queenOfSpades = true;
    } else {
      queenOfSpades = false;
    }
    return queenOfSpades;
  }

  /**
   * Returns the cards in the hand as a String.
   *
   * @return String List of cards in the hand.
   */
  public String getCards() {
    return hand.stream().map(PlayingCard::getAsString)
        .collect(Collectors.joining(" ", "Cards in hand: ", ""));
  }
}