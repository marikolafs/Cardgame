package edu.ntnu.idi.idatt.cardgame;

import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Manages the GUI and launches the application.
 */
public class CardGame extends Application {

  private DeckOfCards deck = new DeckOfCards();
  Random rand = new Random();

  @Override
  public void start(Stage primaryStage) {

    VBox vbox = new VBox();
    VBox newVbox = new VBox();
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(e -> {
      newVbox.getChildren().clear();
      List<PlayingCard> hand = deck.dealHand(rand.nextInt(52) + 1);
      Hand handCards = new Hand(hand);
      hand.forEach(card -> System.out.println(card.getAsString() + " "));
      System.out.println();
      Label handLabel = new Label(handCards.getCards());
      Label flushLabel = new Label("Flush: " + handCards.flush());
      Label sumLabel = new Label("Sum of faces: " + handCards.cardSum());
      Label queenLabel = new Label("Contains queen of spades: " + handCards.queenOfSpades());
      Label heartsLabel = new Label(handCards.hearts());
      newVbox.getChildren().addAll(handLabel, flushLabel, sumLabel, queenLabel, heartsLabel);
    });

    vbox.getChildren().addAll(dealButton, newVbox);

    Scene scene = new Scene(vbox, 1000, 200);
    primaryStage.setTitle("CardGame");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Launches the application.
   *
   * @param args
   */
  public static void main(String[] args) {
    launch();
  }
}