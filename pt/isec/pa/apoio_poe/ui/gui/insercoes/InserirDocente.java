package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoInserido;
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoJaExiste;
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteInserido;
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteJaExiste;

import java.util.Objects;

public class InserirDocente extends BorderPane {
    apoio_poeContext context;


    TextField textNome;
    TextField textEmai;

    Button buttonConfirm;
    Button buttonClose;

    Label labelNome;
    Label labelEmail;

    Font FontLabel = Font.font("Garamond", 14);



    public InserirDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev-> {
            boolean existe = false;
            for (int i = 0; i < context.consultaDocentes().size(); i++) {
                if (Objects.equals(context.consultaDocentes().get(i).getEmail(), textEmai.getText())) {
                    existe = true;
                    Stage stage = new Stage();
                    DocenteJaExiste root = new DocenteJaExiste(context);
                    Scene scene = new Scene(root, 700, 400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Docentes");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
            }
            if (!existe) {
                context.addDocenteSingular(new Docente(textNome.getText(), textEmai.getText()));
                Stage stage = new Stage();
                DocenteJaExiste root = new DocenteJaExiste(context);
                Scene scene = new Scene(root, 700, 400);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Docente");
                stage.setMinWidth(700);
                stage.setMinHeight(400);
                stage.show();
                Stage stage1 = (Stage) this.getScene().getWindow();
                stage1.close();

            }
        });
    }


    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelNome = new Label("");
        labelNome.setText("Insert the professor name");
        grid.add(labelNome, 0, 0);
        labelNome.setFont(FontLabel);

        labelEmail = new Label("");
        labelEmail.setText("Insert the e-mail of the new professor");
        grid.add(labelEmail, 0, 3);
        labelEmail.setFont(FontLabel);

        textNome = new TextField("");
        grid.add(textNome, 0, 1);
        textNome.setStyle("-fx-control-inner-background: #edfaf8");

        textEmai = new TextField("");
        grid.add(textEmai, 0, 4);
        textEmai.setStyle("-fx-control-inner-background: #edfaf8");



        buttonConfirm = new Button("Confirm registry");
        grid.add(buttonConfirm, 5, 4);
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        buttonConfirm.setFont(font);
        buttonConfirm.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 5px;");

        this.setCenter(grid);

    }
}
