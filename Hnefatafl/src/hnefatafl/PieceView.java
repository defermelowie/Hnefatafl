package hnefatafl;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

public class PieceView extends Region {
    private Piece pieceModel;
    private ImageView pieceImageView;

    public PieceView(Piece piece) {
        this.pieceModel = piece;
        this.update();
    }

    public void update() {
        if (pieceModel.isAlive()) {
            if (pieceModel.getType()== Type.KING ){
                pieceImageView = new ImageView("resources/whiteKing.png");
            } else {
                if (pieceModel.getColor() == Color.WHITE) {
                    pieceImageView = new ImageView("resources/whitePawn.png");
                } else {
                    pieceImageView = new ImageView("resources/blackPawn.png");
                }

            }
            this.getChildren().add(pieceImageView);
        }
    }
}

