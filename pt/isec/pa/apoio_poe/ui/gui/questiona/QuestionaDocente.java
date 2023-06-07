package pt.isec.pa.apoio_poe.ui.gui.questiona;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarOrientacaoDeDocente;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraDocente;
import pt.isec.pa.apoio_poe.ui.gui.edicoes.EditarAluno;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.Objects;

public class QuestionaDocente extends BorderPane {
    apoio_poeContext context;

    TextField textEmail;

    Label labelEmail;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            Stage stage = new Stage();
            System.out.println(textEmail.getText());
            ConsultarOrientacaoDeDocente root = new ConsultarOrientacaoDeDocente(context, textEmail.getText());
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

        labelEmail = new Label("");
        labelEmail.setText("Insert the e-mail of the professor you want to view");
        grid.add(labelEmail, 0, 0);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 1);

        buttonConfirm = new Button("View professor");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
