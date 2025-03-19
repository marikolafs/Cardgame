package edu.ntnu.idi.idatt.cardgame;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloApplication extends Application {

  private DeckOfCards deck = new DeckOfCards();

  @Override
  public void start(Stage primaryStage) throws IOException {

    VBox vbox = new VBox();
    VBox newVbox = new VBox();
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(e -> {
      newVbox.getChildren().clear();
      List<PlayingCard> hand = deck.dealHand(5);
      Hand handCards = new Hand(hand);
      hand.forEach(card -> System.out.println(card.getAsString() + " "));
      System.out.println();
      Label handLabel = new Label(handCards.getCards());
      Label flushLabel = new Label("Flush: " + handCards.flush());
      Label sumLabel = new Label("Sum of faces: " + handCards.cardSum());
      Label heartsLabel = new Label(handCards.hearts());
      newVbox.getChildren().addAll(handLabel, flushLabel, sumLabel, heartsLabel);
    });

    vbox.getChildren().addAll(dealButton, newVbox);

    Scene scene = new Scene(vbox, 200, 200);
    primaryStage.setTitle("CardGame");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void showHand(){

    }

  public static void main(String[] args) {
    launch();
  }
}