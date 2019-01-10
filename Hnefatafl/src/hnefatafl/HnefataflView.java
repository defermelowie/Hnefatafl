package hnefatafl;

import javafx.scene.layout.Region;

public class HnefataflView extends Region {
    private Hnefatafl hnefataflModel;

    private BoardView boardView;

    public HnefataflView(Hnefatafl model) {
        this.hnefataflModel = model;
        this.update();
    }

    public void update() {
        getChildren().clear();

        boardView = new BoardView(hnefataflModel.getBoard());
        this.getChildren().add(boardView);
    }

    public BoardView getBoardView(){
        return this.boardView;
    }

    public Piece getPieceOn(int x, int y) {
        /*Board boardModel = hnefataflModel.getBoard();
        BoardView boardView = new BoardView(boardModel);
        return boardView.getPieceOn(x, y);*/
        return (new BoardView(hnefataflModel.getBoard())).getPieceOn(x, y);
    }
}
