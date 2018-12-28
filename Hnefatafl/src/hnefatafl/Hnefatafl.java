package hnefatafl;

/**
 * @author Stef, Mika, Lowie
 */
public class Hnefatafl {
    private Board board;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player CurrentPlayer;

    /**
     * Constructor for class Hnefatafl
     */
    public Hnefatafl() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.whitePlayer.setPieces(board.getPiecesByColor(Color.WHITE));
        this.blackPlayer = new BlackPlayer();
        this.blackPlayer.setPieces((board.getPiecesByColor(Color.BLACK)));
    }

    //getters

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }
}
