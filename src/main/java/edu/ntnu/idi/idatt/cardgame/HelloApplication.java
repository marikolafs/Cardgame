package edu.ntnu.idi.idatt.cardgame;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class HelloApplication extends Application {

  private DeckOfCards deck = new DeckOfCards();

  @Override
  public void start(Stage primaryStage) throws IOException {

    VBox vbox = new VBox();
    Button dealButton = new Button("Deal hand");
    dealButton.setOnAction(e -> {
          List<PlayingCard> hand = deck.dealHand(5);
          Hand handCards = new Hand(hand);

          hand.forEach(card -> System.out.println(card.getAsString() + " "));
          System.out.println();

          System.out.println("Flush: " + handCards.flush());
          System.out.println("Sum of faces: " + handCards.cardSum());
          System.out.println(handCards.hearts());
        });

    vbox.getChildren().addAll(dealButton);

    Scene scene = new Scene(vbox);
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