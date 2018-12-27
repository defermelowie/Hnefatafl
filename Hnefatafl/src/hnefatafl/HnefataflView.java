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
            pieceView.setTranslateX(p.getColumn()*70 + 10);
            pieceView.setTranslateY(p.getRow()*70 + 10);
            getChildren().add(pieceView);
        }
    }

    public Piece getPieceOn(int row, int column){
        return null; //TODO
    }
}
