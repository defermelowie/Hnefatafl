/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author mikaz
 */
public class Player {
    private Boolean color;
    private int Pawns;
    private int Kings;
    private  ArrayList<Piece> pieces=new ArrayList<>();
/**
 * 
 * @param color true if White, false if Black
 */
 public Player(Boolean color){
     this.color = color;
     if(color == true){
         for( int i = 0; i < 9; i++){
             pieces.add(new Pawn(0,0,color));
         }
         pieces.add(new King(5,5));
     }
     else{
          for( int i = 0; i <17; i++){
             pieces.add(new Pawn(0,0,false));
     }
         
 }
    
}
}
