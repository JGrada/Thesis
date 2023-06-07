package pt.isec.pa.apoio_poe.ui.gui.consultas;

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
import pt.isec.pa.apoio_poe.ui.gui.avisos.DocenteNaoExiste;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.Objects;

public class ConsultarDocente extends BorderPane {
    apoio_poeContext context;

    TextField textMail;

    Label labelMail;

    Button buttonConfirm;

    GridPane grid;

    public ConsultarDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            boolean eliminei = false;
            for(int i = 0; i < context.consultaDocentes().size(); i++) {
                if (Objects.equals(context.consultaDocentes().get(i).getEmail(), textMail.getText())) {
                    Stage stage = new Stage();
                    MostraDocente root = new MostraDocente(context, textMail.getText());
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Professor");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                    eliminei = true;
                }

            }
            if(!eliminei){
                Stage stage = new Stage();
                DocenteNaoExiste root = new DocenteNaoExiste(context);
                Scene scene = new Scene(root,700,400);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Professor");
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

        labelMail = new Label("");
        labelMail.setText("Insert the e-mail of the professor you are trying to view");
        grid.add(labelMail, 0, 0);

        textMail = new TextField("");
        grid.add(textMail, 0, 1);

        buttonConfirm = new Button("View professor");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
