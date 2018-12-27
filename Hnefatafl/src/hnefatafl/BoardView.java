package hnefatafl;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

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
    }
}
