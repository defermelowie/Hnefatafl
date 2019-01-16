package hnefatafl;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

import java.awt.Image;

/**
 * Class for a view of a piece which is used in the game
 *
 * @author Stef, Mika, Lowie
 */
public class PieceView extends Region {
    private Piece pieceModel;
    private ImageView pieceImageView;


    /**
     * Constructor for PieceView
     */
    public PieceView(Piece piece) {
        this.pieceModel = piece;
        this.update();
    }


    /**
     * updates the view of the piece
     */
    public void update() {
        if (pieceModel.isAlive()) {
            if (pieceModel.getType() == Type.KING) {
                pieceImageView = new ImageView("resources/whiteKing.png");
            } else if (pieceModel.getType() == Type.PAWN) {
                if (pieceModel.getColor() == Color.WHITE) {
                    pieceImageView = new ImageView("resources/whitePawn.png");
                } else {
                    pieceImageView = new ImageView("resources/blackPawn.png");
                }

            } /*else if (pieceModel.getType() == Type.BARRIER) {
                pieceImageView = new ImageView("resources/hardBarrier.png");
            } else if (pieceModel.getType() == Type.SOFTBARRIER) {                      //uncomment to show barrier pieces
                pieceImageView = new ImageView("resources/softBarrier.png");
            }*/
            if (pieceImageView != null)
                this.getChildren().add(pieceImageView);
        }
    }
}

