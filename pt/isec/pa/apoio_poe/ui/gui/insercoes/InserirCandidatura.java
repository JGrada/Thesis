package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.avisos.AlunoInserido;
import pt.isec.pa.apoio_poe.ui.gui.avisos.CandidaturaInserida;
import pt.isec.pa.apoio_poe.ui.gui.avisos.CandidaturaJaExiste;
import pt.isec.pa.apoio_poe.ui.gui.avisos.PropostaJaExiste;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class InserirCandidatura extends BorderPane {
    apoio_poeContext context;

    TextField textNrAluno;
    Label labelnr;
    TextField textPropostas;
    Label labelPropostas;
    Button buttonConfirm;
    GridPane grid;
    ArrayList<String> propostasAssociadas = new ArrayList<String>();

    public InserirCandidatura(apoio_poeContext context){
        super();
        this.context = context;
        createViews();
        registerHandlers();
    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            boolean existe = false;
            for (int i = 0; i < context.consultaCandidaturas().size(); i++) {
                if (context.consultaCandidaturas().get(i).getNumero() == Long.parseLong(textNrAluno.getText())) {
                    existe = true;
                    Stage stage = new Stage();
                    CandidaturaJaExiste root = new CandidaturaJaExiste(context);
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
            if(!existe){
                System.out.println("Estou aki com k");
                propostasAssociadas.add(Arrays.toString(textPropostas.getText().split(",")));
                context.addCandidaturaIndividual(new Candidatura(Long.parseLong(textNrAluno.getText()), propostasAssociadas));
                Stage stage = new Stage();
                CandidaturaInserida root = new CandidaturaInserida(context);
                Scene scene = new Scene(root,700,400);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Candidatura");
                stage.setMinWidth(700);
                stage.setMinHeight(400);
                stage.show();
                Stage stage1 = (Stage) this.getScene().getWindow();
                stage1.close();
            }

        });
    }

    private void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelnr = new Label("");
        labelnr.setText("Insert the number of the student associated with this application");
        grid.add(labelnr, 0, 0);
        labelnr.getStyleClass().add("labelInsereAluno");

        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 2);

        labelPropostas = new Label("");
        labelPropostas.setText("Inser the ID of the proposals attached to this application, seperated by commas");

        grid.add(labelPropostas, 0, 4);
        labelPropostas.getStyleClass().add("labelInsereAluno");

        textPropostas = new TextField("");
        grid.add(textPropostas, 0, 6);

        buttonConfirm = new Button("Confirm application");
        grid.add(buttonConfirm, 2, 6);

        buttonConfirm.getStyleClass().add("buttonConfirm");

        setCenter(grid);


    }
}
