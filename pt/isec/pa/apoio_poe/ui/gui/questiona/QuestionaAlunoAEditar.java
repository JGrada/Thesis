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
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.edicoes.EditarAluno;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuestionaAlunoAEditar extends BorderPane {
    apoio_poeContext context;

    TextField textNr;

    Label labelNr;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaAlunoAEditar(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            boolean existe = false;
            for(int i = 0; i < context.consultarAlunos().size(); i++) {
                if (context.consultarAlunos().get(i).getNumero() == Long.parseLong(textNr.getText())) {
                    Stage stage = new Stage();
                    System.out.println(textNr.getText());
                    EditarAluno root = new EditarAluno(context, Long.parseLong(textNr.getText()));
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Aluno");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();

                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                    existe = true;
                }
            }
            if(!existe){
                Stage stage = new Stage();
                AlunoNaoExiste root = new AlunoNaoExiste(context);
                Scene scene = new Scene(root,700,400);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Lista de alunos");
                stage.setMinWidth(700);
                stage.setMinHeight(400);
                stage.show();
                Stage stage1 = (Stage) this.getScene().getWindow();
                stage1.close();
            }

        });
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelNr = new Label("");
        labelNr.setText("Insert the number of the student you want to edit");
        grid.add(labelNr, 0, 0);

        textNr = new TextField("");
        grid.add(textNr, 0, 1);

        buttonConfirm = new Button("Edit student");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
