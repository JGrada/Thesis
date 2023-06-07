package pt.isec.pa.apoio_poe.ui.gui.remocoes;

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
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.avisos.PropostaNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.Objects;

public class RemoverProposta extends BorderPane {
    apoio_poeContext context;

    TextField textID;

    Label labelID;

    Button buttonConfirm;

    GridPane grid;

    public RemoverProposta(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            boolean eliminei = false;
            for(int i = 0; i < context.consultarPropostas().size(); i++) {
                if (Objects.equals(context.consultarPropostas().get(i).getIdProposta(), textID.getText())) {
                    context.removerProposta(textID.getText());
                    eliminei = true;

                    Stage stage = (Stage) this.getScene().getWindow();
                    stage.close();
                }

            }
            if(!eliminei){
                Stage stage = new Stage();
                PropostaNaoExiste root = new PropostaNaoExiste(context);
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
        /*
        buttonConfirm.setOnAction(ev->{
            context.removerProposta(textID.getText());
            System.out.println("O aluno foi removido");

            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });*/
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelID = new Label("");
        labelID.setText("Insert the ID of the proposal you want to remove");
        grid.add(labelID, 0, 0);

        textID = new TextField("");
        grid.add(textID, 0, 1);

        buttonConfirm = new Button("Remove proposal");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}

