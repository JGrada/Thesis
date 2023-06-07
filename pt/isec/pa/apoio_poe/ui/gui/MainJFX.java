package pt.isec.pa.apoio_poe.ui.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

import java.net.MalformedURLException;


public class MainJFX extends Application {
    public apoio_poeContext context;
    public MainJFX() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        configurarJanela(stage);
        //configurarJanela(new Stage());


    }

    public void configurarJanela(Stage stage) throws MalformedURLException {
        Apoio_poeGUI root = new Apoio_poeGUI(apoio_poeContext.getInstance());
        Scene scene = new Scene(root,800,800);

        stage.setScene(scene);
        stage.setTitle("Management of thesis subjects");
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();
    }


}
