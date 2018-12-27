package hnefatafl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class HnefataflController {
    Hnefatafl hnefataflModel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private Button StartBtn;

    @FXML
    void initialize() {
        assert gamePane != null : "fx:id=\"gamePane\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";
        assert StartBtn != null : "fx:id=\"StartBtn\" was not injected: check your FXML file 'FXMLHnefataflView.fxml'.";

    }

    public void setModel(Hnefatafl hnefataflModel){
        this.hnefataflModel = hnefataflModel;
        HnefataflView hnefataflView = new HnefataflView(hnefataflModel);
        gamePane.getChildren().add(hnefataflView);
    }
}

