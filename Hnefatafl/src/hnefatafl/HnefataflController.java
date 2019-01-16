package hnefatafl;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;

/**
 * Controller class for the game
 *
 * @author Stef, Mika, Lowie
 */
public class HnefataflController {
    private Hnefatafl hnefataflModel;

    private BoardView boardView;
    @FXML
    private AnchorPane gamePane;
    @FXML
    private Button restartBtn;
    @FXML
    private Label timerWhiteLbl;
    @FXML
    private Label timerBlackLbl;
    @FXML
    private Button loadBtn;
    @FXML
    private Button saveBtn;

    /**
     * Connects the events to the functions that handle it
     */
    @FXML
    void initialize() {
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert restartBtn != null : "fx:id=\"restartBtn\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert timerWhiteLbl != null : "fx:id=\"timerWhiteLbl\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert timerBlackLbl != null : "fx:id=\"timerBlackLbl\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert loadBtn != null : "fx:id=\"loadBtn\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";

        gamePane.setOnMouseClicked(event -> handleMouseClick(event));
        restartBtn.setOnAction(event -> handleRestartBtn(event));
        loadBtn.setOnAction(event -> handleLoadBtn(event));
        saveBtn.setOnAction(event -> handleSaveBtn(event));
    }

    public void setModel(Hnefatafl hnefataflModel) {
        this.hnefataflModel = hnefataflModel;
        boardView = new BoardView(hnefataflModel.getBoard());
        gamePane.getChildren().add(boardView);
        gamePane.setFocusTraversable(true);
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();
        if (hnefataflModel.getBoard().isPieceSelected()) {
            boolean madeTurn = hnefataflModel.moveSelectedPieceTo(boardView.getRow(y), boardView.getColumn(x));
            hnefataflModel.updateBoard();
            if (hnefataflModel.isGameFinished()) {
                boardView.update();
                new EndDialogBox(hnefataflModel.getCurrentPlayer(), this);
            } else if (madeTurn) {
                hnefataflModel.endTurn();
            }
        } else {
            hnefataflModel.selectPieceOn(boardView.getRow(y), boardView.getColumn(x));
        }
        boardView.update();

        //printout
        if (hnefataflModel.getBoard().isPieceSelected()) {
            System.out.println("Selected Piece --> " + hnefataflModel.getBoard().getSelectedPiece());
        } else {
            System.out.println("Current Player --> " + hnefataflModel.getCurrentPlayer());
        }
    }

    public void handleRestartBtn(Event e) {
        hnefataflModel.startup();
        setModel(hnefataflModel);
    }

    public void handleRestartBtn() {
        hnefataflModel.startup();
        setModel(hnefataflModel);
    }

    public void handleLoadBtn(Event e) {
        hnefataflModel.updateTo(Hnefatafl.loadFromJson());
        setModel(hnefataflModel);
    }

    private void handleSaveBtn(Event e) {
        hnefataflModel.saveToJson();
    }

    public void updateTimers() {
        timerWhiteLbl.setText("White playtime: " + hnefataflModel.getWhitePlayer().getPlayTime());
        timerBlackLbl.setText("Black playtime: " + hnefataflModel.getBlackPlayer().getPlayTime());
    }


}
