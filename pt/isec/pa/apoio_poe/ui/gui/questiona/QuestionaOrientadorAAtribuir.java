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
import pt.isec.pa.apoio_poe.ui.gui.edicoes.EditarCandidatura;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuestionaOrientadorAAtribuir extends BorderPane {
    apoio_poeContext context;

    TextField textNr;
    TextField textEmail;
    TextField textIDproposta;

    Label labelNr;
    Label labelEmail;
    Label labelIDProposta;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaOrientadorAAtribuir(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.atribuirManualmenteOrientadorAAlunosComPropostas(Long.parseLong(textNr.getText()), textEmail.getText(), textIDproposta.getText());
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

        labelNr = new Label("");
        labelNr.setText("Insert the number of the student that you want to add a coordinator to");
        grid.add(labelNr, 0, 0);

        labelEmail = new Label("");
        labelEmail.setText("Insert the email of the professor");
        grid.add(labelEmail, 0, 3);

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insert the ID of the proposal you want to assign the coordinator");
        grid.add(labelIDProposta, 0, 6);

        textNr = new TextField("");
        grid.add(textNr, 0, 1);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 4);

        textIDproposta = new TextField("");
        grid.add(textIDproposta, 0, 7);

        buttonConfirm = new Button("Assign coordinator");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
