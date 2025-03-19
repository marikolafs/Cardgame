package edu.ntnu.idi.idatt.cardgame;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {
  private List<PlayingCard> hand;
  PlayingCard card;

  public Hand(List<PlayingCard> hand) {
    this.hand = hand;
  }

  /**
   * Teller mengden av hver spill farge og returnerer sant hvis det finnes 5 av en farge i hånden.
   * @return
   */
  public boolean flush(){
    Map<Character, Long> suitCount = hand.stream().collect(
        Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));
    return suitCount.containsValue(5L);
  }

  public int cardSum(){
    return hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  public String hearts(){
    return hand.stream().filter(card -> card.getSuit() == 'H').map(PlayingCard::getAsString).collect(
        Collectors.joining(" ", "Heart cards: ", ""));
  }
}