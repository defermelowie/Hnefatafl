/* Verdeling tijd taak java:
    Mika Zimmermann --> 35%
    Lowie Deferme --> 45%
    Stef Loos --> 20%
 */
package hnefatafl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Stef Loos, Mika Zimmermann, Lowie Deferme
 */
public class HnefataflMain extends Application {
    /**
     * Starts the application
     */
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
        Thread t = new Thread(new PlayerTimer(hnefataflModel, hnefataflController));
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
