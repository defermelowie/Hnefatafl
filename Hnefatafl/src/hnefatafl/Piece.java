/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hnefatafl;

/**
 *
 * @author mikaz
 */
public class Piece {
    int row;
    int column;
    Boolean color;

    /**
     * Constructor for piece
     * @param row Row on the board for the new piece
     * @param column Column on the board for the new piece
     * @param color 1 if White, 0 if Black
     */
    public Piece(int row, int column, Boolean color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }
}
