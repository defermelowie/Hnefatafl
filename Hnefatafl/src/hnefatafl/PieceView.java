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
        if (pieceModel.isAlive()) {                                                     //als het stuk leeft:
            if (pieceModel.getType() == Type.KING) {                                    //en het stuk is een konging
                pieceImageView = new ImageView("resources/whiteKing.png");          //teken een koning
            } else if (pieceModel.getType() == Type.PAWN) {                             //en als het stuk een pion is
                if (pieceModel.getColor() == Color.WHITE) {                             //en het is wit
                    pieceImageView = new ImageView("resources/whitePawn.png");      //teken een witte pion
                } else {                                                                //anders (stuk is zwart)
                    pieceImageView = new ImageView("resources/blackPawn.png");      //teken een zwarte pion
                }

            } /*else if (pieceModel.getType() == Type.BARRIER) {
                pieceImageView = new ImageView("resources/hardBarrier.png");
            } else if (pieceModel.getType() == Type.SOFTBARRIER) {                      //uncomment to show barrier pieces
                pieceImageView = new ImageView("resources/softBarrier.png");
            }*/
            if (pieceImageView != null)                                                 //als er een foto ingeladen is (de ingelade foto != null)
                this.getChildren().add(pieceImageView);                                 //voeg de foto toe aan pieceView
        }
    }
}

