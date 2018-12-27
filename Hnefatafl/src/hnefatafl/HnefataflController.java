package hnefatafl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HnefataflController {
    Hnefatafl hnefataflModel;
    HnefataflView hnefataflView;

    @FXML
    private AnchorPane gamePane;

    @FXML
    void initialize() {
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        gamePane.setOnMouseClicked(event -> handleMouseClick(event));
    }

    public void setModel(Hnefatafl hnefataflModel){
        this.hnefataflModel = hnefataflModel;
        hnefataflView = new HnefataflView(hnefataflModel);
        gamePane.getChildren().add(hnefataflView);
        gamePane.setFocusTraversable(true);
    }

    public void handleMouseClick(MouseEvent mouseEvent){
        int x = (int)mouseEvent.getX();
        int y = (int)mouseEvent.getY();
        Piece clickedPiece = hnefataflModel.getBoard().getPieceOn(hnefataflView.getRow(x),hnefataflView.getColumn(y));
        if (clickedPiece != null){
            System.out.println(clickedPiece.toString());
        }
    }
}

