package hnefatafl;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.layout.Region;
import javafx.scene.image.ImageView;

public class BoardView extends Region {
    private Board boardModel;
    private ImageView boardImageView;

    public BoardView(Board board) {
        this.boardModel = board;
        this.update();
    }

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

    public int getRow(int y) {
        return y / 70;
    }

    public int getColumn(int x) {
        return x / 70;
    }

    public Piece getPieceOn(int y, int x){
        return boardModel.getPieceOn(this.getRow(y), getColumn(x));
    }
}
