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
     * Checks if this piece is alive
     *
     * @return true if this piece is alive, false otherwise
     */
    public Boolean isAlive() {
        return alive;
    }
    
    
    /**
     * Gets the row of this piece
     *
     * @return the row of this piece 
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of this piece
     *
     * @return the column of this piece 
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the color of this piece
     *
     * @return the color of this piece 
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the coordinates of this piece
     *
     * @return an array with the row and the column of a selected piece
     */
    public int[] getCoordinates() {
        int[] c = {this.row, this.column};
        return c;
    }
 
    /**
     * Gets the type of this piece
     *
     * @return king if this piece is a king, pawn if this piece is a pawn
     */
    public Type getType() {
        return type;
    }

    //setters
    /**
     * Sets the coordinates of this piece
     * 
     *@param row  Row-coordinate of this piece
     *@param column  Column-coordinate of this piece
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
     * Moves this piece
     * 
     *@param row  Row-coordinate of new place
     *@param column  Column-coordinate of new place
     * 
     * @return true if this piece is moved, false if this piece isn't moved
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
     * kills this piece
     * 
     */
    public void kill() {
        this.alive = false;
        this.row = -1;
        this.column = -1;
    }

    /**
     * Check if this piece can kill other pieces
     * 
     *@return false if this piece is a softbarrier, else true
     */
    public boolean canKill() {
        if (this.type == Type.SOFTBARRIER) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Overrides standard string method and makes a formatted string of this object
     */
    @Override
    public String toString() {
        return "Type: " + this.type + " | Color: " + this.color + " | Row: " + this.row + " | Column: " + this.column + " | Alive: " + this.alive;
    }


}
    
    

