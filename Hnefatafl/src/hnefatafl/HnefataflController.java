package hnefatafl;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;

public class HnefataflController {
    private Hnefatafl hnefataflModel;

    private BoardView boardView;
    //private HnefataflView hnefataflView;
    @FXML
    private AnchorPane gamePane;
    @FXML
    private Button restartBtn;
    @FXML
    private Label timerWhiteLbl;
    @FXML
    private Label timerBlackLbl;

    @FXML
    void initialize() {
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert restartBtn != null : "fx:id=\"restartBtn\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert timerWhiteLbl != null : "fx:id=\"timerWhiteLbl\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert timerBlackLbl != null : "fx:id=\"timerBlackLbl\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        gamePane.setOnMouseClicked(event -> handleMouseClick(event));
        restartBtn.setOnAction(event -> handleRestartBtn(event));
    }

    public void setModel(Hnefatafl hnefataflModel) {
        this.hnefataflModel = hnefataflModel;

        boardView = new BoardView(hnefataflModel.getBoard());
        gamePane.getChildren().add(boardView);
        gamePane.setFocusTraversable(true);
        this.updateTimers();
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();
        if (hnefataflModel.getBoard().isPieceSelected()) {
            boolean madeTurn = hnefataflModel.moveSelectedPieceTo(boardView.getRow(y), boardView.getColumn(x));
            hnefataflModel.updateBoard();
            hnefataflModel.isGameFinished();
            if (madeTurn) {
                hnefataflModel.endTurn();
            }
        } else {
            hnefataflModel.selectPieceOn(boardView.getRow(y), boardView.getColumn(x));
        }

        //printout
        if (hnefataflModel.getBoard().isPieceSelected()) {
            System.out.println("Selected Piece --> " + hnefataflModel.getBoard().getSelectedPiece());
        } else {
            System.out.println("Current Player --> " + hnefataflModel.getCurrentPlayer());
        }

        boardView.update();
        //hnefataflView.update();
    }

    public void handleRestartBtn(Event e) {
        this.setModel(new Hnefatafl());
    }

    public void updateTimers() {
        timerWhiteLbl.setText("White playtime: " + hnefataflModel.getWhitePlayer().getPlaytime());
        timerBlackLbl.setText("Black playtime: " + hnefataflModel.getBlackPlayer().getPlaytime());
    }


}
