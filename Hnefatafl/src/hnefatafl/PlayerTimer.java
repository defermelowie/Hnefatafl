/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import javafx.application.Platform;

/**
 *
 * @author Stef
 */
public class PlayerTimer implements Runnable{
    
    private Hnefatafl model;

    public PlayerTimer(Hnefatafl model) {
        this.model = model;
    }
    
    @Override
    public void run() {
        while (true){
            try{
            Thread.sleep(10) ;
            Player player = model.getCurrentPlayer();
            player.addToTimer(10);
            //Platform.runLater( () -> );
        } catch (InterruptedException e){
            //do nothing
        }
        
    }
    } 
}
