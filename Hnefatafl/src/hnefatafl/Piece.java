package hnefatafl;

/**
 * @author mikaz
 */
public class Piece {
    private int row;
    private int column;
    private Color color;
    private Boolean alive;
    private Type type;
    private boolean murder;

    /**
     * Constructor for piece
     *
     * @param row    Row on the board for the new piece
     * @param column Column on the board for the new piece
     * @param color  true if White, false if Black
     * @param  murder if true can slay other pieces
     */
    public Piece(int row, int column, Color color, Type type, boolean murder) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.alive = true;
        this.type = type;
        this.murder = murder;
    }


    /**
     * Constructor for piece
     *
     * @param coordinates Array with {row, column}
     * @param color       true if White, false if Black
     */
    public Piece(int[] coordinates, Color color, Type type, boolean murder) {
        this.row = coordinates[0];
        this.column = coordinates[1];
        this.color = color;
        this.alive = true;
        this.type = type;
        this.murder = murder;
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

    public int[] getCoordinates() {
        int[] c = {this.row, this.column};
        return c;
    }

    public Type getType() {
        return type;
    }

    //setters
    private void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setAliveTo(Boolean alive) {
        this.alive = alive;
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

    public void kill() {
        this.alive = false;
        this.row = -1;
        this.column = -1;
    }
    
    public boolean canKill(){
        return murder;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " | Color: " + this.color + " | Row: " + this.row + " | Column: " + this.column + " | Alive: " + this.alive;
    }


}
    
    

