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

        gamePane.setOnMouseClicked(event -> handleMouseClick(event));       //links de juiste (handler)functie met een voorval/event
        restartBtn.setOnAction(event -> handleRestartBtn(event));           //links de juiste (handler)functie met een voorval/event
        loadBtn.setOnAction(event -> handleLoadBtn(event));                 //links de juiste (handler)functie met een voorval/event
        saveBtn.setOnAction(event -> handleSaveBtn(event));                 //links de juiste (handler)functie met een voorval/event
    }

    public void setModel(Hnefatafl hnefataflModel) {
        this.hnefataflModel = hnefataflModel;                               //sets het model
        boardView = new BoardView(hnefataflModel.getBoard());               //maakt een nieuwe bordView aan de hand van het model
        gamePane.getChildren().add(boardView);                              //voegt die bordview toe aan gamePane
        gamePane.setFocusTraversable(true);                                 //zorgt ervoor dat een muisklik op gamePane geregistreerd wordt
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();                                    //gets the x-coordinaat van de pixel waarop geklikt is
        int y = (int) mouseEvent.getY();                                    //gets the y-coordinaat van de pixel waarop geklikt is
        if (hnefataflModel.getBoard().isPieceSelected()) {                  //als er een stuk geselelcteerd is
            boolean madeTurn = hnefataflModel.moveSelectedPieceTo(boardView.getRow(y), boardView.getColumn(x)); //probeer het stuk te bewegen en sla "succes" op in de variable madeTurn
            hnefataflModel.updateBoard();                                   //update het bordModel
            if (hnefataflModel.isGameFinished()) {                          //als het spel gedaan is
                boardView.update();                                         //update de bordView
                new EndDialogBox(hnefataflModel.getCurrentPlayer(), this);  //maak de end popup
            } else if (madeTurn) {                                          //als het spel nog niet gedaan is maar de beurd is afgelopen (het stuk is succesvol verplaatst)
                hnefataflModel.endTurn();                                   //laat het model weten dat de beurt gedaan is
            }
        } else {                                                            //als er geen stuk geselecteerd was
            hnefataflModel.selectPieceOn(boardView.getRow(y), boardView.getColumn(x)); //selecteer een stuk
        }
        boardView.update();                                                 //update de bordView

        //Methods to print the status into the console output
        if (hnefataflModel.getBoard().isPieceSelected()) {
            System.out.println("Selected Piece --> " + hnefataflModel.getBoard().getSelectedPiece());
        } else {
            System.out.println("Current Player --> " + hnefataflModel.getCurrentPlayer());
        }
    }

    public void handleRestartBtn(Event e) {                                 //handles de restart button in het gamevenster
        hnefataflModel.startup();
        setModel(hnefataflModel);
    }

    public void handleRestartBtn() {                                        //handles de restart button in de endDialogBox
        hnefataflModel.startup();
        setModel(hnefataflModel);
    }

    public void handleLoadBtn(Event e) {
        hnefataflModel.updateTo(Hnefatafl.loadFromJson());                  //updates het model naar een nieuw ingeladen model
        setModel(hnefataflModel);                                           //zorgt dat de controller het juiste (pas ingeladen) model heeft
    }

    private void handleSaveBtn(Event e) {
        hnefataflModel.saveToJson();                                        //slaat het model op
    }

    public void updateTimers() {
        timerWhiteLbl.setText("White playtime: " + hnefataflModel.getWhitePlayer().getPlayTime());  //updates het label dat de witte speeltijd weergeeft
        timerBlackLbl.setText("Black playtime: " + hnefataflModel.getBlackPlayer().getPlayTime());  //updates het label dat de zwarte speeltijd weergeeft
    }


}
