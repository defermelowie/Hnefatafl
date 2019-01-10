package hnefatafl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Stef, Mika, Lowie
 */
public class HnefataflMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Model
        Hnefatafl hnefataflModel = new Hnefatafl();

        //View
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHnefataflView.fxml"));
        Parent root = loader.load();

        //Controller
        HnefataflController hnefataflController = loader.getController();

        //Link model to controller
        hnefataflController.setModel(hnefataflModel);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
