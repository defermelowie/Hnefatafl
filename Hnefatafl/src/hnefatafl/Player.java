/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import java.util.ArrayList;

/**
 *
 * @author mikaz
 */
public class Player {
    private Color color;
    private int Pawns;
    private int Kings;
    private  ArrayList<Piece> pieces = new ArrayList<>();

    /**
     *  Constructor for player
     * @param color true if White, false if Black
     */
     public Player(Color color){
         this.color = color;
         if(color == Color.WHITE){
             for( int i = 0; i < 9; i++){
                 pieces.add(new Pawn(0,0, Color.WHITE));
             }
             pieces.add(new King(5,5));
         }
         else {
             for (int i = 0; i < 17; i++) {
                 pieces.add(new Pawn(0, 0, Color.BLACK));
             }

         }
    }
}
