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
public class PlayerTimer implements Runnable {
    private Hnefatafl model;
    private HnefataflController controller;

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
                Thread.sleep(10);
                Player player = model.getCurrentPlayer();
                player.addToTimer(10);
                Platform.runLater(() -> controller.updateTimers());
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
}
