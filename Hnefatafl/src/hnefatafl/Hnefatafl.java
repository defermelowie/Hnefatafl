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
     * Starts up the game
     */
    public void startup() {
        this.board = new Board();
        this.whitePlayer = new WhitePlayer();
        this.blackPlayer = new BlackPlayer();
        this.currentPlayer = whitePlayer;
    }


    /**
     * Updates the game to a new model
     *
     * @param newHnefatafl new hnefatafl game
     */
    public void updateTo(Hnefatafl newHnefatafl) {
        this.board = newHnefatafl.getBoard();
        this.whitePlayer = newHnefatafl.getWhitePlayer();
        this.blackPlayer = newHnefatafl.getBlackPlayer();
        this.currentPlayer = newHnefatafl.getCurrentPlayer();
    }

    //Json methods

    /**
     * Loads the Json file into the model
     */
    public static Hnefatafl loadFromJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Player.class, new PlayerDeSerializer());
        Gson gson = gsonBuilder.create();
        try {
            Hnefatafl loadedModel = gson.fromJson(new FileReader("ModelSave.json.txt"), Hnefatafl.class);
            return loadedModel;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Hnefatafl();
        }
    }

    /**
     * Saves the model to ModelSave.json.txt in Json format
     */
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
     * Gets the board where's currently played on
     *
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the current player
     *
     * @return The current player
     */

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the white player
     *
     * @return The white player
     */
    public WhitePlayer getWhitePlayer() {
        return whitePlayer;
    }

    /**
     * Gets the black player
     *
     * @return The black player
     */

    public BlackPlayer getBlackPlayer() {
        return blackPlayer;
    }

    //other methods

    /**
     * selects a certain piece
     *
     * @param row    Row-coordinate of piece
     * @param column Column-coordinate of piece
     * @return true if the piece is succesfully selected, false otherwise
     */
    public boolean selectPieceOn(int row, int column) {
        if (board.getPieceOn(row, column) != null && board.getPieceOn(row, column).getColor() == currentPlayer.getColor()) {
            return board.selectPieceOn(row, column);
        } else {
            return false;
        }
    }

    /**
     * Moves a selected piece to a new row and column
     *
     * @param row    Row-coordinate of piece
     * @param column Column-coordinate of piece
     * @return The piece moves to the new row and column
     */
    public boolean moveSelectedPieceTo(int row, int column) {
        return board.moveSelectedPieceTo(row, column);
    }

    /**
     * Kills a captured piece
     */
    public void killCapturedPieces() {
        board.killCapturedPieces(currentPlayer.getColor());
    }

    /**
     * Sets for the hardbarriers around the board
     *
     * @return The barriers are placed
     */
    private void setBarriers() {
        board.setBarriers();
    }

    /**
     * Updates the board
     */
    public void updateBoard() {
        killCapturedPieces();
        setBarriers();
    }

    /**
     * Changes the current player after a turn
     */
    public void endTurn() {
        if (currentPlayer instanceof WhitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }

    /**
     * Checks if the game is finished
     *
     * @return true if the game is finished, false otherwise
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
