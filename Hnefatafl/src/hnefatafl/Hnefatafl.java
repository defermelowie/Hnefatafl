package hnefatafl;

/**
 * Main game class
 *
 * @author Stef, Mika, Lowie
 */
public class Hnefatafl {
    private Board board;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player CurrentPlayer;

    /**
     * Constructor for Hnefatafl (game)
     */
    public Hnefatafl() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.whitePlayer.setPieces(board.getPiecesByColor(Color.WHITE));
        this.blackPlayer = new BlackPlayer();
        this.blackPlayer.setPieces((board.getPiecesByColor(Color.BLACK)));
    }

    //getters

    /**
     * Getter for the board that belongs to this game
     *
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter for the white player
     *
     * @return The white player
     */
    public Player getWhitePlayer() {
        return whitePlayer;
    }

    /**
     * Getter for the black player
     *
     * @return The black player
     */
    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }
}
