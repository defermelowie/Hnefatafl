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
    Boolean alive;

    /**
     * Constructor for piece
     * @param row Row on the board for the new piece
     * @param column Column on the board for the new piece
     * @param color true if White, false if Black
     */
    public Piece(int row, int column, Boolean color) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.alive = true;
    }

    /**
     * Constructor for piece
     * @param coordinates Array with {row, column}
     * @param color true if White, false if Black
     */
    public Piece(int coordinates[], Boolean color) {
        this.row = coordinates[0];
        this.column = coordinates[1];
        this.color = color;
        this.alive = true;
    }


    public Boolean isAlive() {
        return alive;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    
    
    
    
    }
    
    

