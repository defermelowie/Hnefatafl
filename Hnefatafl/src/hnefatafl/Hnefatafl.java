package hnefatafl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main game class
 *
 * @author Stef, Mika, Lowie
 */
public class Hnefatafl {

    private Board board;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player currentPlayer;
    private boolean showTimer;


    /**
     * Constructor for Hnefatafl (game)
     */
    public Hnefatafl() {
        this.startup();
    }

    public void startup() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.blackPlayer = new BlackPlayer();
        this.currentPlayer = whitePlayer;
        this.showTimer = true;
    }

    public void updateTo(Hnefatafl newHnefatafl){
        this.board = newHnefatafl.getBoard();
        this.whitePlayer = newHnefatafl.getWhitePlayer();
        this.blackPlayer = newHnefatafl.getBlackPlayer();
        this.currentPlayer = newHnefatafl.getCurrentPlayer();
        this.showTimer = true;
    }

    }

    //getters
    /**
     * Getter for the board that belongs to this game
     *
     * @return The board
     */
    public boolean isTimerOn() {
        return showTimer;
    }

    private void turnTimerOff() {
        showTimer = false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public WhitePlayer getWhitePlayer() {
        return whitePlayer;
    }

    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }

    //other methods
    public boolean selectPieceOn(int row, int column) {
        if (board.getPieceOn(row, column) != null && board.getPieceOn(row, column).getColor() == currentPlayer.getColor()) {
            return board.selectPieceOn(row, column);
        } else {
            return false;
        }
    }

    public boolean moveSelectedPieceTo(int row, int column) {
        return board.moveSelectedPieceTo(row, column);
    }

    public void killCapturedPieces() {
        board.killCapturedPieces(currentPlayer.getColor());
    }

    private void setBarriers() {
        board.setBarriers();
    }

    public void updateBoard() {
        killCapturedPieces();
        setBarriers();
    }

    public void endTurn() {
        if (currentPlayer instanceof WhitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }

    public boolean isGameFinished() {
        blackPlayer.checkDeath(board.getPiecesByColor(Color.BLACK));
        whitePlayer.checkDeath(board.getPiecesByColor(Color.WHITE));
        if (blackPlayer.isAlive() == false || board.isWhiteKingOnCorner()) {
            System.out.println("This Game has ended: White player wins");
            board.fillWithPieces(Color.WHITE);
            turnTimerOff();
            return true;
        } else if (whitePlayer.isAlive() == false) {
            System.out.println("This Game has ended: Black player wins");
            board.fillWithPieces(Color.BLACK);
            turnTimerOff();
            return true;
        }
        return false;
    }
}
