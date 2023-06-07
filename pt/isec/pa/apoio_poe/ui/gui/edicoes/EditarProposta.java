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
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteEditado;
import pt.isec.pa.apoio_poe.ui.gui.avisos.PropostaEditada;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class EditarProposta extends BorderPane {
    apoio_poeContext context;

    TextField textNrAluno;
    TextField textTipoProposta;
    TextField textTitulo;



    CheckBox isAtribuida;
    Button buttonConfirm;
    Button buttonClose;

    Label labelTipoProposta;
    Label labelNrAluno;
    Label labelTitulo;
    Label labelAtribuida;

    GridPane grid;

    String ID;


    public EditarProposta(apoio_poeContext context, String ID) {
        super();
        this.context = context;
        this.ID = ID;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            context.editarProposta(ID, Long.parseLong(textNrAluno.getText()),
                    textTitulo.getText(), textTipoProposta.getText(), isAtribuida.isSelected());
            Stage stage = new Stage();
            PropostaEditada root = new PropostaEditada(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Proposta");
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


        labelTipoProposta = new Label("");
        labelTipoProposta.setText("Insert the type of proposal");
        grid.add(labelTipoProposta, 0, 3);
        labelTipoProposta.getStyleClass().add("labelInsereAluno");

        labelNrAluno = new Label("");
        labelNrAluno.setText("Insert the number of the student attached to the proposal");
        grid.add(labelNrAluno, 0, 6);
        labelNrAluno.getStyleClass().add("labelInsereAluno");

        labelTitulo = new Label("");
        labelTitulo.setText("Insert the type of proposal");
        grid.add(labelTitulo, 0, 9);
        labelTitulo.getStyleClass().add("labelInsereAluno");

        labelAtribuida = new Label("");
        labelAtribuida.setText("Is this the proposal assigned");
        grid.add(labelAtribuida, 0, 12);
        labelAtribuida.getStyleClass().add("labelInsereAluno");




        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 7);

        textTitulo = new TextField("");
        grid.add(textTitulo, 0, 10);

        textTipoProposta = new TextField("");
        grid.add(textTipoProposta, 0, 4);

        isAtribuida = new CheckBox("");
        grid.add(isAtribuida, 0, 13);

        buttonConfirm = new Button("Confirmar edicao");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}