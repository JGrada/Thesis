package pt.isec.pa.apoio_poe.ui.gui.edicoes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class EditarOrientadorProposta extends BorderPane {
    apoio_poeContext context;

    TextField textEmail;



    Button buttonConfirm;
    Button buttonClose;

    Label labelEmail;

    GridPane grid;

    String IdProposta;


    public EditarOrientadorProposta(apoio_poeContext context, String IDproposta) {
        super();
        this.context = context;
        this.IdProposta = IDproposta;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            context.editarOrientadorDeProposta(IdProposta, textEmail.getText());
            Stage stage1 = (Stage) this.getScene().getWindow();
            stage1.close();
        });

    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelEmail = new Label("");
        labelEmail.setText("Insert the e-mail of the professor you want to attach to the proposal");
        grid.add(labelEmail, 0, 3);
        labelEmail.getStyleClass().add("labelInsereAluno");

        textEmail = new TextField("");
        grid.add(textEmail, 0, 7);


        buttonConfirm = new Button("Confirm edition");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}