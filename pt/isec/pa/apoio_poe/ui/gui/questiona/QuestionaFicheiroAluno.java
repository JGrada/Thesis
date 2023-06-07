package pt.isec.pa.apoio_poe.ui.gui.questiona;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuestionaFicheiroAluno extends BorderPane {
    apoio_poeContext context;

    TextField textFile;

    Label labelFile;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaFicheiroAluno(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.exportarAlunosParaCSV(textFile.getText());
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

        labelFile = new Label("");
        labelFile.setText("To what file you want to export");
        grid.add(labelFile, 0, 0);

        textFile = new TextField("");
        grid.add(textFile, 0, 1);

        buttonConfirm = new Button("Export");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
