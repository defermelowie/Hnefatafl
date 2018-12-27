package hnefatafl;

/**
 * @author mikaz
 */
public class Hnefatafl {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player CurrentPlayer;

    public Hnefatafl() {
        this.board = new Board();
        this.whitePlayer = new Player(Color.WHITE);
        this.whitePlayer.setPieces(board.getPiecesByColor(Color.WHITE));
        this.blackPlayer = new Player(Color.BLACK);
        this.blackPlayer.setPieces((board.getPiecesByColor(Color.BLACK)));
    }

    public Board getBoard() {
        return board;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }
}
