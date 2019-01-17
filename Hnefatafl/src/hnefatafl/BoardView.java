package hnefatafl;

import java.util.Iterator;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

/**
 * Class for the board view
 *
 * @author Stef, Mika, Lowie
 */
public class BoardView extends Region {
    private Board boardModel;                                                       //holds het model dat afgebeeld moet worden
    private ImageView boardImageView;                                               //holds de achtergrond foto van het bord

    /**
     * Constructor for the BoardView
     *
     * @param board the model that needs to be drawn
     */
    public BoardView(Board board) {
        this.boardModel = board;                                                    //sets het model dat afgebeeld moet worden
        this.update();
    }

    /**
     * updates the view of the board
     */
    public void update() {
        boardImageView = new ImageView("resources/gameBoard.png");              //laad de achtergrond afbeelding van het bord in
        this.getChildren().add(boardImageView);                                     //voegt deze afbeelding toe aan de bordView

        Iterator<Piece> piecesModel = boardModel.getPieces();                       //laad alle stukken uit het bordmodel in
        while (piecesModel.hasNext()) {                                             //zolang dat er een volgend stuk in de lijst zit
            Piece p = piecesModel.next();                                           //p = het volgende stuk en daarna schuif een stuk op (een plaats verder in de lijst)
            PieceView pieceView = new PieceView(p);                                 //maak een nieuwe stukView van het stuk p
            pieceView.setTranslateX(p.getColumn() * 70 + 10);                       //one tile on the board is 70x70, +10 because a piece is 50x50
            pieceView.setTranslateY(p.getRow() * 70 + 10);                          //          "                   "                   "
            getChildren().add(pieceView);                                           //voeg deze stukView toe aan bordView
        }                                                                           //dit wordt gedaan totdat alle stukken doorlopen zijn (er geen volgend stuk meer is
    }

    /**
     * Gets the row of a certain y-coordinate
     *
     * @param y certain y-coordinate
     * @return the row of the y-coordinate
     */
    public int getRow(int y) {
        return y / 70;
    }

    /**
     * Gets the column of a certain x-coordinate
     *
     * @param x certain x-coordinate
     * @return the column of the y-coordinate
     */
    public int getColumn(int x) {
        return x / 70;
    }

    /**
     * Gets a piece by it's coordinates
     *
     * @param y y-coordinate
     * @param x x-coordinate
     * @return the piece that's on the coordinates
     */
    public Piece getPieceOn(int y, int x) {
        return boardModel.getPieceOn(this.getRow(y), getColumn(x));
    }
}
