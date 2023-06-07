package pt.isec.pa.apoio_poe.ui.gui.remocoes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class RemoverAtribuicaoPropostaManualmente extends BorderPane {
    apoio_poeContext context;

    TextField textNr;

    Label labelNr;

    Button buttonConfirm;

    GridPane grid;

    public RemoverAtribuicaoPropostaManualmente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.removerPropostaManualmente(Long.parseLong(textNr.getText()));

            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelNr = new Label("");
        labelNr.setText("Insert the number of the student you want to remove proposal");
        grid.add(labelNr, 0, 0);

        textNr = new TextField("");
        grid.add(textNr, 0, 1);

        buttonConfirm = new Button("Remove");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}

