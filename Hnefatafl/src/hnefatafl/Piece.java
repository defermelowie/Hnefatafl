package hnefatafl;

/**
 * @author mikaz
 */
public class Piece {
    protected int row;
    protected int column;
    protected Color color;
    protected Boolean alive;

    /**
     * Constructor for piece
     *
     * @param row    Row on the board for the new piece
     * @param column Column on the board for the new piece
     * @param color  true if White, false if Black
     */
    public Piece(int row, int column, Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.alive = true;
    }

    /**
     * Constructor for piece
     *
     * @param coordinates Array with {row, column}
     * @param color       true if White, false if Black
     */
    public Piece(int[] coordinates, Color color) {
        this.row = coordinates[0];
        this.column = coordinates[1];
        this.color = color;
        this.alive = true;
    }

    //getters
    public Boolean isAlive() {
        return alive;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return this.color;
    }

    //setters
    private void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //other methods
    public boolean moveTo(int row, int column) {
        if (this.row == row || this.column == column) {
            setCoordinates(row, column);
            return true;
        } else {
            return false;
        }
    }
}
    
    

