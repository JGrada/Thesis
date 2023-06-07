package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.application.Platform;
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
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.GESTAO_PROPState;
import pt.isec.pa.apoio_poe.model.fsm.IApoio_poeState;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.avisos.*;

import java.util.Objects;

public class InserirProposta extends BorderPane {
    apoio_poeContext context;


    TextField textNrAluno;
    TextField textTipoProposta;
    TextField textIDProposta;
    TextField textTitulo;


    CheckBox isAtribuida;
    Button buttonConfirm;
    Button buttonClose;

    Label labelIDProposta;
    Label labelTipoProposta;
    Label labelNrAluno;
    Label labelTitulo;
    Label labelAtribuida;


    public InserirProposta(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev-> {
            boolean existe = false;
            for (int i = 0; i < context.consultarPropostas().size(); i++) {
                if (Objects.equals(context.consultarPropostas().get(i).getIdProposta(), textIDProposta.getText())) {
                    existe = true;
                    Stage stage = new Stage();
                    PropostaJaExiste root = new PropostaJaExiste(context);
                    Scene scene = new Scene(root, 700, 400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Proposta");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
            }
            if(!existe){
                if(Objects.equals(textTipoProposta.getText(), "T1") || Objects.equals(textTipoProposta.getText(), "T2")
                        || Objects.equals(textTipoProposta.getText(), "T3")){
                    context.addPropostaSingular(new Proposta(textTipoProposta.getText(), textIDProposta.getText(), Long.parseLong(textNrAluno.getText()),
                            textTitulo.getText(), isAtribuida.isSelected()));
                    Stage stage = new Stage();
                    PropostaInserida root = new PropostaInserida(context);
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Proposta");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
                else{
                    Stage stage = new Stage();
                    TipoPropostaNaoExiste root = new TipoPropostaNaoExiste(context);
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Proposta");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
            }
        });
    }

    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelTipoProposta = new Label("");
        labelTipoProposta.setText("What's the type of this proposal");
        grid.add(labelTipoProposta, 0, 0);

        labelIDProposta = new Label("");
        labelIDProposta.setText("What is the students number attached to this proposal ");
        grid.add(labelIDProposta, 0, 3);

        labelNrAluno = new Label("");
        labelNrAluno.setText("Insert the ID of the proposal");
        grid.add(labelNrAluno, 0, 6);

        labelTitulo = new Label("");
        labelTitulo.setText("Insert the title of this proposal");
        grid.add(labelTitulo, 0, 9);

        labelAtribuida = new Label("");
        labelAtribuida.setText("Is this proposal already taken");
        grid.add(labelAtribuida, 0, 12);

        textTipoProposta = new TextField("");
        grid.add(textTipoProposta, 0, 1);

        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 4);

        textIDProposta = new TextField();
        grid.add(textIDProposta, 0, 7);

        textTitulo = new TextField("");
        grid.add(textTitulo, 0, 10);

        isAtribuida = new CheckBox("");
        grid.add(isAtribuida, 0, 13);



        buttonConfirm = new Button("Confirm proposal");
        grid.add(buttonConfirm, 2, 13);
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        buttonConfirm.setFont(font);
        buttonConfirm.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 2px;");




        this.setCenter(grid);



    }
}