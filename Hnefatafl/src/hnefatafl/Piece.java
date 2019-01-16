package hnefatafl;

/**
 * Class for a piece which is used in the game
 * @author mika, stef, lowie
 */
public class Piece {
    private int row;
    private int column;
    private Color color;
    private Boolean alive;
    private Type type;

    /**
     * Constructor for piece
     *
     * @param row    Row on the board for the new piece
     * @param column Column on the board for the new piece
     * @param color  true if White, false if Black
     * @param type type of piece
     */
    public Piece(int row, int column, Color color, Type type) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.alive = true;
        this.type = type;
    }


    /**
     * Constructor for piece
     *
     * @param coordinates Array with {row, column}
     * @param color       true if White, false if Black
     * @param type        type of piece 
     */
    public Piece(int[] coordinates, Color color, Type type) {
        this.row = coordinates[0];
        this.column = coordinates[1];
        this.color = color;
        this.alive = true;
        this.type = type;
    }

    //getters
    
   /**
     * Getter to check if player is alive
     *
     * @return true if player is alive, false if player isn't alive
     */
    public Boolean isAlive() {
        return alive;
    }
    
    
    /**
     * Getter for the row of a selected piece
     *
     * @return the row of the selected piece 
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for the column of a selected piece
     *
     * @return the column of the selected piece 
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter for the color of a selected piece
     *
     * @return the color of the selected piece 
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter for the coordinates of a selected piece
     *
     * @return an array with the row and the column of the selected piece
     */
    public int[] getCoordinates() {
        int[] c = {this.row, this.column};
        return c;
    }

    /**
     * Getter for the type of a selected piece
     *
     * @return king if the selected piece is a king, pawn if the selected piece is a pawn
     */
    public Type getType() {
        return type;
    }

    //setters
    /**
     * Setter for the coordinates of a piece
     * 
     *@param row  Row-coordinate of piece
     *@param column  Column-coordinate of piece
     */
    private void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Setter to change player in dead or alive
     * 
     *@param alive  true is player is alive, false if player isn't alive
     *
     */
    public void setAliveTo(Boolean alive) {
        this.alive = alive;
    }

    //other methods
    
    /**
     * Method to move a selected piece
     * 
     *@param row  Row-coordinate of new place
     *@param column  Column-coordinate of new place
     * 
     * @return true if piece is moved, false if piece isn't moved
     */
    public boolean moveTo(int row, int column) {
        if (this.row == row || this.column == column) {
            setCoordinates(row, column);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to kill a certain piece
     * 
     */
    public void kill() {
        this.alive = false;
        this.row = -1;
        this.column = -1;
    }

    /**
     * Method to check if a piece can kill another piece
     * 
     *@return false if the piece is a softbarrier, else true
     */
    public boolean canKill() {
        if (this.type == Type.SOFTBARRIER) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " | Color: " + this.color + " | Row: " + this.row + " | Column: " + this.column + " | Alive: " + this.alive;
    }


}
    
    

