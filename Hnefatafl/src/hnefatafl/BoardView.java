package hnefatafl;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

/**
 * Class for the view of the board on which the game is played
 *
 * @author Stef, Mika, Lowie
 */

public class BoardView extends Region {
    private Board boardModel;
    private ImageView boardImageView;

    /**
     * Constructor for boardview class
     */
    public BoardView(Board board) {
        this.boardModel = board;
        this.update();
    }

    /**
     * update function for the view of the board
     * 
     * 
     */
    
    public void update() {
        boardImageView = new ImageView("resources/gameBoard.png");
        this.getChildren().add(boardImageView);

        Iterator<Piece> piecesModel = boardModel.getPieces();
        while (piecesModel.hasNext()) {
            Piece p = piecesModel.next();
            PieceView pieceView = new PieceView(p);
            pieceView.setTranslateX(p.getColumn() * 70 + 10); //one tile on the board is 70x70, +10 because a piece is 50x50
            pieceView.setTranslateY(p.getRow() * 70 + 10);
            getChildren().add(pieceView);
        }
    }
    
    /**
     * Gets the row in which a selected Piece is located
     *
     * @param y Y-coordinate of the selected piece
     * @return The number of the row in which the piece is located
     */

    public int getRow(int y) {
        return y / 70;
    }

    /**
     * Gets the column in which a selected Piece is located
     *
     * @param x X-coordinate of the selected piece
     * @return The number of the column in which the piece is located
     */
    public int getColumn(int x) {
        return x / 70;
    }

    /**
     * moves a selected piece to a chosen row and column
     *
     * @param x X-coordinate of the place you want to move the piece to
     * @param y Y-coordinate of the place you want to move the piece to
     * @return shows the piece moved to the chosen row and column
     */
    public Piece getPieceOn(int y, int x){
        return boardModel.getPieceOn(this.getRow(y), getColumn(x));
    }
}

