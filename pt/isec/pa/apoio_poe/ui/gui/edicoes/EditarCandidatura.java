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
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoInserido;
import pt.isec.pa.apoio_poe.ui.gui.avisos.CandidaturaEditada;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class EditarCandidatura extends BorderPane {
    apoio_poeContext context;

    TextField textPropostas;



    Button buttonConfirm;
    Button buttonClose;

    Label labelPropostas;

    GridPane grid;

    long nr;

    ArrayList<String> propostasAssociadas = new ArrayList<String>();

    public EditarCandidatura(apoio_poeContext context, long nr) {
        super();
        this.context = context;
        this.nr = nr;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            for(String s : textPropostas.getText().split(",")){
                propostasAssociadas.add(s);
            }
           context.editarCandidatura(nr, propostasAssociadas);
            Stage stage = new Stage();
            CandidaturaEditada root = new CandidaturaEditada(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
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


        labelPropostas = new Label("");
        labelPropostas.setText("Insert the proposals you want to add seperated by commas");
        grid.add(labelPropostas, 0, 3);
        labelPropostas.getStyleClass().add("labelInsereAluno");

        textPropostas = new TextField("");
        grid.add(textPropostas, 0, 7);


        buttonConfirm = new Button("Confirm edition");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}