package hnefatafl;

import javafx.scene.layout.Region;

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
    }

    public Piece getPieceOn(int row, int column){
        return null; //TODO
    }
}
