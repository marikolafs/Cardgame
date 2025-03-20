import edu.ntnu.idi.idatt.cardgame.Hand;
import edu.ntnu.idi.idatt.cardgame.PlayingCard;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HandTest {

  @Nested
  @DisplayName("Flush tests")
  class FlushTests {

    @Test
    @DisplayName("Should find a flush")
    void shouldFindAFlush() {
      List<PlayingCard> flushHand = List.of(
          new PlayingCard('H', 1), new PlayingCard('H', 2),
          new PlayingCard('H', 3), new PlayingCard('H', 4),
          new PlayingCard('H', 5));
      Hand hand = new Hand(flushHand);
      assertTrue(hand.flush());
    }

    @Test
    @DisplayName("should not find flush")
    void shouldNotFindFlush() {
      List<PlayingCard> flushHand = List.of(
          new PlayingCard('S', 1), new PlayingCard('H', 2),
          new PlayingCard('H', 3), new PlayingCard('H', 4),
          new PlayingCard('H', 5));
      Hand hand = new Hand(flushHand);
      assertTrue(!hand.flush());
    }
  }

  @Test
  @DisplayName("Should find the sum of faces")
  void shouldFindTheSumOfFaces() {
    List<PlayingCard> sumHand = List.of(
        new PlayingCard('H', 1), new PlayingCard('H', 2));
    Hand hand = new Hand(sumHand);
    assertEquals(1 + 2, hand.cardSum());
  }

  @Test
  @DisplayName("Should return heart cards")
  void shouldReturnHeartCards() {
    List<PlayingCard> heartHand = List.of(
        new PlayingCard('H', 1), new PlayingCard('S', 2),
        new PlayingCard('H', 3), new PlayingCard('S', 4));
    Hand hand = new Hand(heartHand);
    assertEquals("Heart cards: H1 H3", hand.hearts());
  }

  @Nested
  @DisplayName("Queen of spades tests")
  class QueenOfSpadesTests {
    @Test
    @DisplayName("Should return true when queen of spades is in hand")
    void shouldReturnTrueWhenQueenOfSpadesIsInHand() {
      List<PlayingCard> spadesHand = List.of(
          new PlayingCard('H', 12), new PlayingCard('S', 12),
          new PlayingCard('C', 12), new PlayingCard('D', 12));
      Hand hand = new Hand(spadesHand);
      assertTrue(hand.queenOfSpades());
    }

    @Test
    @DisplayName("Should return false when queen of spades is in hand")
    void shouldReturnFalseWhenQueenOfSpadesIsInHand() {
      List<PlayingCard> spadesHand = List.of(
          new PlayingCard('H', 12), new PlayingCard('C', 12),
          new PlayingCard('D', 12));
      Hand hand = new Hand(spadesHand);
      assertTrue(!hand.queenOfSpades());
    }
  }
}

