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
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoEditado;
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteEditado;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class EditarDocente extends BorderPane {
    apoio_poeContext context;

    TextField textNome;
    TextField textEmail;

    CheckBox isAcesso;
    Button buttonConfirm;
    Button buttonClose;


    Label labelNr;
    Label labelNome;
    Label labelEmail;
    Label labelSiglaCurso;
    Label labelSiglaRamo;
    Label labelPontuacao;
    Label labelIDProposta;
    Label labelAcessoEstagio;
    GridPane grid;

    String email;


    public EditarDocente(apoio_poeContext context, String email) {
        super();
        this.context = context;
        this.email = email;
        createViews();
        registerHandlers();


    }

    private void registerHandlers() {

        buttonConfirm.setOnAction(ev -> {
            context.editarDocente(email, textNome.getText());
            Stage stage = new Stage();
            DocenteEditado root = new DocenteEditado(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Docente");
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


        labelNome = new Label("");
        labelNome.setText("Insert the name of the professor");
        grid.add(labelNome, 0, 3);
        labelNome.getStyleClass().add("labelInsereAluno");

        textNome = new TextField("");
        grid.add(textNome, 0, 7);


        buttonConfirm = new Button("Confirm edition");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}