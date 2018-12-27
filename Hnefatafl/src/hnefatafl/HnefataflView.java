package hnefatafl;

import javafx.scene.layout.Region;

import java.util.ArrayList;

public class HnefataflView extends Region {
    private Hnefatafl hnefataflModel;

    public HnefataflView(Hnefatafl model) {
        this.hnefataflModel = model;
        this.update();
    }

    public void update() {
        getChildren().clear();

        Board boardModel = hnefataflModel.getBoard();
        BoardView boardView = new BoardView(boardModel);
        this.getChildren().add(boardView);

        ArrayList<Piece> piecesModel = boardModel.getPieces();
        for (Piece p : piecesModel){
            PieceView pieceView = new PieceView(p);
            pieceView.setTranslateX(p.getColumn()*70 + 10); //one tile on the board is 70x70, +10 because a piece is 50x50
            pieceView.setTranslateY(p.getRow()*70 + 10);
            getChildren().add(pieceView);
        }
    }

    public int getRow(int x){
        return x/70;
    }

    public int getColumn(int y){
        return y/70;
    }

}
