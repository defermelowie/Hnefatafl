/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import javafx.application.Platform;

/**
 * @author Stef, Lowie, Mika
 */
public class PlayerTimer implements Runnable {  //implements runnable zorgt ervoor dat we van deze klasse een thread kunnen maken
    private Hnefatafl model;                    //het model dat bij iedere tick aangepast moet worden
    private HnefataflController controller;     //de controller die de view mag updaten

    /**
     * Creates a new timer
     *
     * @param model      The model that this timer should change
     * @param controller The controller that this timer should use to change the view
     */
    public PlayerTimer(Hnefatafl model, HnefataflController controller) {
        this.model = model;
        this.controller = controller;
    }

    /**
     * Implementation of the run method of the interface Runnable
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);                                   //wacht 10 milliseconden
                Player player = model.getCurrentPlayer();
                player.addToTimer(10);                             //voegt 10 milliseconden toe bij de huidige speler zijn speeltijd
                Platform.runLater(() -> controller.updateTimers());      //updates de labels die te speeltijden laten zien, platform.runLater zorgt ervoor dat dit via de main thread gebeurt
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
}
