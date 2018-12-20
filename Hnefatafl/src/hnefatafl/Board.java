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
public class Board {
    private ArrayList<Piece> whitePieces = new ArrayList<>();
    private ArrayList<Piece> blackPieces = new ArrayList<>();

    private int whiteStartLayout[][] = {
            {6,4} , {6,5} , {6,6} ,
            {5,4} , {5,6} ,
            {4,4} , {4,5} , {4,6} ,
            {5,5}
    };

    private int blackStartLayout[][] = {
            {1,4} , {1,5} , {1,6} , {2,5} ,
            {4,1} , {5,1} , {6,1} , {5,2} ,
            {9,4} , {9,5} , {9,6} , {8,5} ,
            {4,9} , {5,9} , {6,9} , {5,8} ,
    };

    public Board() {

        for (int i = 0; i < 8; i++){
            whitePieces.add(new Pawn(whiteStartLayout[i], true));
        }
        whitePieces.add(new King(whiteStartLayout[8]));

        for (int i = 0; i < 16; i++){
            blackPieces.add(new Pawn(blackStartLayout[i], false));
        }
    }
}
