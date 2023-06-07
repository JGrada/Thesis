package pt.isec.pa.apoio_poe.ui.gui;

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
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class ConfirmarSaida extends BorderPane {
    GridPane grid;
    apoio_poeContext context;
    Button buttonSim;
    Button buttonNao;

    Label labelQuestion;

    public ConfirmarSaida(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonNao.setOnAction(ev->{
            Platform.exit();
        });
        buttonSim.setOnAction(ev->{
            context.save();
            Platform.exit();
        });

    }

    private void createViews(){
        CSSManager.applyCSS(this, "mystyles.css");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelQuestion = new Label("");
        labelQuestion.setText("Do you want to save?");
        grid.add(labelQuestion, 0, 0);
        labelQuestion.getStyleClass().add("labelEscolha");


        buttonSim = new Button("Yes");
        grid.add(buttonSim, 0, 2);
        buttonSim.getStyleClass().add("buttonConfirm");

        buttonNao = new Button("No");
        grid.add(buttonNao, 1, 2);
        buttonNao.getStyleClass().add("buttonConfirm");


        this.setCenter(grid);
    }

}
