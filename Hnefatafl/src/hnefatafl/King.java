/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

/**
 *class for King piece
 * @author Stef, Mika, Lowie
 */
public class King extends Piece{

    /**
     * constructor for King
     * @param row Row on the board for the new pawn
     * @param column Column on the board for the new pawn
     */
    public King(int row, int column) {
        super(row, column, true);   //color of the king is always white
    }
}
