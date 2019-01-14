/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mikaz
 */
public class EndDialogBox {

    public EndDialogBox(Player winner, HnefataflController c) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The game has ended!");
        alert.setHeaderText(null);
        String Winner;
        if (winner.getColor() == Color.WHITE) {
            Winner = "White player wins!!!";
        } else {
            Winner = "Black player wins!!!";
        }
        ButtonType restartButton = new ButtonType("Restart");
        alert.getButtonTypes().setAll(restartButton);
        alert.setContentText(Winner);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == restartButton){
         c.handleRestartBtn();
    }
}
}
