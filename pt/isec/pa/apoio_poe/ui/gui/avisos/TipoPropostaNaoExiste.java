package pt.isec.pa.apoio_poe.ui.gui.avisos;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class TipoPropostaNaoExiste extends BorderPane {
    GridPane grid;
    apoio_poeContext context;
    Button buttonOkay;


    Label labelInfo;

    public TipoPropostaNaoExiste(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonOkay.setOnAction(ev->{
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });

    }

    private void createViews(){
        CSSManager.applyCSS(this, "mystyles.css");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelInfo = new Label("");
        labelInfo.setText("That type of proposal doesn't exist");
        grid.add(labelInfo, 0, 0);


        buttonOkay = new Button("Close");
        grid.add(buttonOkay, 0, 2);
        buttonOkay.getStyleClass().add("buttonConfirm");



        this.setCenter(grid);
    }

}
