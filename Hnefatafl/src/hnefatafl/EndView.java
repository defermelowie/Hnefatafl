/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import javafx.scene.control.Alert;

/**
 *
 * @author mikaz
 */
public class EndView {

    public EndView(Player winner) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("game end");
    alert.setHeaderText(null);
    if (winner.getColor() == Color.WHITE){
    alert.setContentText("White player wins!!!");
    }else{
        alert.setContentText("Black player wins!!!");
    }

    alert.showAndWait();
         
    }
    
    
}
