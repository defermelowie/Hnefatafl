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

    /**
     * Constructor for Hnefatafl (game)
     */
    public Hnefatafl() {
        this.startup();
    }

      /**
     * method to start up the game
     *
     */
    public void startup() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.blackPlayer = new BlackPlayer();
        this.currentPlayer = whitePlayer;
    }


      /**
     * method to update the game
     *
     * @return game is updated
     */
    public void updateTo(Hnefatafl newHnefatafl){
        this.board = newHnefatafl.getBoard();
        this.whitePlayer = newHnefatafl.getWhitePlayer();
        this.blackPlayer = newHnefatafl.getBlackPlayer();
        this.currentPlayer = newHnefatafl.getCurrentPlayer();
    }

    //Json methods
    public static Hnefatafl loadFromJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Player.class, new PlayerDeSerialiser());
        Gson gson = gsonBuilder.create();
        try {
            Hnefatafl loadedModel = gson.fromJson(new FileReader("ModelSave.json.txt"), Hnefatafl.class);
            return loadedModel;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Hnefatafl();
        }
    }

    public void saveToJson() {
        Gson gsonner = new GsonBuilder().setPrettyPrinting().create();
        String json = gsonner.toJson(this);
        try {
            JsonWriter writer = gsonner.newJsonWriter(new FileWriter("ModelSave.json.txt"));
            writer.jsonValue(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //getters

    /**
     * Getter for the board that belongs to this game
     *
     * @return timer is showed
     */

     /**
     * Getter for the board that belongs to this game
     *
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

     /**
     * Getter for the current player
     *
     * @return The current player
     */

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

     /**
     * Getter for the white player
     *
     * @return The white player
     */
    public WhitePlayer getWhitePlayer() {
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

    //other methods

     /**
     * method to select a certain piece
     *
     * @param row    Row-coordinate of piece
     * @param column Column-coordinate of piece
     * @return The piece with the coordinates specified by the parameters, returns false if it's a piece from the other player or if ther's no piece on the selected place
     */
    public boolean selectPieceOn(int row, int column) {
        if (board.getPieceOn(row, column) != null && board.getPieceOn(row, column).getColor() == currentPlayer.getColor()) {
            return board.selectPieceOn(row, column);
        } else {
            return false;
        }
    }

     /**
     * method to move a selected piece to a new row and column
     *
     * @param row    Row-coordinate of piece
     * @param column Column-coordinate of piece
     * @return The piece moves to the new row and column
     */
    public boolean moveSelectedPieceTo(int row, int column) {
        return board.moveSelectedPieceTo(row, column);
    }

     /**
     * method to kill a capture piece
     *
     * @return The piece is killed
     */
    public void killCapturedPieces() {
        board.killCapturedPieces(currentPlayer.getColor());
    }

     /**
     * Setter for the barriers around the board
     *
     * @return The barriers are placed
     */
    private void setBarriers() {
        board.setBarriers();
    }

    /**
     * method to update the board (check if any pieces are killed and place barrier where needed)
     *
     */
    public void updateBoard() {
        killCapturedPieces();
        setBarriers();
    }

    /**
     * method to change the current player after a turn
     *
     * @return blackplayer is current player if a white player has moved a piece, else it's still the white player's turn
     */
    public void endTurn() {
        if (currentPlayer instanceof WhitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }

    /**
     * method to check if the game is finished
     *
     * @return true if one of the players is death or the white king is on a corner, false if both players are alive or the king isn't on a corner
     */
    public boolean isGameFinished() {
        blackPlayer.checkDeath(board.getPiecesByColor(Color.BLACK));
        whitePlayer.checkDeath(board.getPiecesByColor(Color.WHITE));
        if (blackPlayer.isAlive() == false || board.isWhiteKingOnCorner()) {
            System.out.println("This Game has ended: White player wins");
            board.fillWithPieces(Color.WHITE);
            return true;
        } else if (whitePlayer.isAlive() == false) {
            System.out.println("This Game has ended: Black player wins");
            board.fillWithPieces(Color.BLACK);
            return true;
        }
        return false;
    }
}
