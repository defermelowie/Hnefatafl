package hnefatafl;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HnefataflController {

    Hnefatafl hnefataflModel;
    HnefataflView hnefataflView;

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
        gamePane.setOnMouseClicked(event -> handleMouseClick(event));
        restartBtn.setOnAction(event -> handleRestartBtn(event));
        //deSelectBtn.setOnAction(event -> handleDeSelect(event));
    }

    public void setModel(Hnefatafl hnefataflModel) {
        this.hnefataflModel = hnefataflModel;
        hnefataflView = new HnefataflView(hnefataflModel);
        gamePane.getChildren().add(hnefataflView);
        gamePane.setFocusTraversable(true);
        updateTimers();
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();
        if (hnefataflModel.getBoard().isPieceSelected()) {
            boolean madeTurn = hnefataflModel.moveSelectedPieceTo(hnefataflView.getBoardView().getRow(y), hnefataflView.getBoardView().getColumn(x));
            hnefataflModel.updateBoard();
            hnefataflModel.isGameFinished();
            if (madeTurn) {
                this.updateTimer();
                hnefataflModel.endTurn();
            }
        } else {
            hnefataflModel.selectPieceOn(hnefataflView.getBoardView().getRow(y), hnefataflView.getBoardView().getColumn(x));
        }

        //printout
        if (hnefataflModel.getBoard().isPieceSelected()) {
            System.out.println("Selected Piece --> " + hnefataflModel.getBoard().getSelectedPiece());
        } else {
            //System.out.println("No piece selected");
            System.out.println("Current Player --> " + hnefataflModel.getCurrentPlayer());
        }

        hnefataflView.update();
    }

    public void updateTimer() {
        if (hnefataflModel.getCurrentPlayer() instanceof WhitePlayer) {
            timerWhiteLbl.setText("White playtime: " + hnefataflModel.getCurrentPlayer().getPlaytime());
        } else if (hnefataflModel.getCurrentPlayer() instanceof BlackPlayer) {
            timerBlackLbl.setText("Black playtime: " + hnefataflModel.getCurrentPlayer().getPlaytime());
        }
    }

    public void updateTimers() {
        timerWhiteLbl.setText("White playtime: " + hnefataflModel.getWhitePlayer().getPlaytime());
        timerBlackLbl.setText("Black playtime: " + hnefataflModel.getBlackPlayer().getPlaytime());
    }
    
    public void handleDeSelect(Event e) {
        hnefataflModel.getBoard().DeSelectPiece();
    }

    public void handleRestartBtn(Event e) {
        hnefataflModel.start();
        hnefataflView.update();
        this.updateTimers();
    }
}
