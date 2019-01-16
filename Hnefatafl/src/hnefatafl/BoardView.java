package hnefatafl;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

/**
 * Class for the board view
 *
 * @author Stef, Mika, Lowie
 */
public class BoardView extends Region {
    private Board boardModel;
    private ImageView boardImageView;

    /**
 * Constructor for the BoardView
 *
 * @param board the model that needs to be drawn 
 */
    public BoardView(Board board) {
        this.boardModel = board;
        this.update();
    }

 /**
 * updates the view of the board
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
 * Gets the row of a certain y-coordinate
 *
 *@param y certain y-coordinate
 * @return the row of the y-coordinate
 */
    public int getRow(int y) {
        return y / 70;
    }

/**
 * Gets the column of a certain x-coordinate
 *
 *@param x certain x-coordinate
 * @return the column of the y-coordinate
 */
    public int getColumn(int x) {
        return x / 70;
    }

/**
 * Gets a piece by it's coordinates 
 *
  *@param y y-coordinate
 * @param x x-coordinate  
 * 
 * @return the piece that's on the coordinates
 */
    public Piece getPieceOn(int y, int x){
        return boardModel.getPieceOn(this.getRow(y), getColumn(x));
    }
}
