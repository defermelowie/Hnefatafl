/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

/**
 * class for Pawn piece
 * @author Stef, Mika, Lowie
 */
public class Pawn extends Piece {

    /**
     * Constructor for pawn
     * @param row Row on the board for the new pawn
     * @param column Column on the board for the new pawn
     * @param color true if White, false if Black
     */
    public Pawn(int row, int column, Boolean color) {
        super(row, column, color);
    }

    /**
     * Constructor for pawn
     * @param coordinates an array with {row, column}
     * @param color true if White, false if Black
     */
    public Pawn(int coordinates[], Boolean color) {
        super(coordinates, color);
    }
}
