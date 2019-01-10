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

        //show stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //start timer thread
        Thread t = new Thread(new PlayerTimer(hnefataflModel));
        t.setDaemon(true);
        t.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
