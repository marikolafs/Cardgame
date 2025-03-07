module edu.ntnu.idi.idatt.cardgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ntnu.idi.idatt.cardgame to javafx.fxml;
    exports edu.ntnu.idi.idatt.cardgame;
}