package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.AtribuirPropostaManualmente;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.InserirAluno;
import pt.isec.pa.apoio_poe.ui.gui.remocoes.RemoverAtribuicaoPropostaManualmente;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class GESTAO_MANUAL_ATRIB extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;




    Button ButtonAtribuirAutoproposta;
    Button ButtonPropostasDeDocentes;
    Button ButtonVoltarFase3;
    Button ButtonAtribuirPropostaManualmente;
    Button ButtonRemoverAtribuicaoPropostaManualmente;

    Label mensagemEscolha;
    Label listaDeAlunos;


    public GESTAO_MANUAL_ATRIB(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonAtribuirAutoproposta.setOnAction(ev->context.atribuirAutoproposta());
        ButtonPropostasDeDocentes.setOnAction(ev->context.atribuirPropostaDeDocente());
        ButtonVoltarFase3.setOnAction(ev->context.changeFromGestaoManualAtribToFase3());
        ButtonAtribuirPropostaManualmente.setOnAction(ev->{
            Stage stage = new Stage();
            AtribuirPropostaManualmente root = new AtribuirPropostaManualmente(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Insert proposal manually");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverAtribuicaoPropostaManualmente.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverAtribuicaoPropostaManualmente root = new RemoverAtribuicaoPropostaManualmente(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Remove proposal manually");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_MANUAL_ATRIBSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){

        //toolBar = new WindowToolBar(context);
        //toolBar.createViews();
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option");


        ButtonAtribuirAutoproposta = new Button();
        ButtonAtribuirAutoproposta.setText("Assign autoproposal");
        ButtonAtribuirAutoproposta.getStyleClass().add("buttonFase2");

        ButtonPropostasDeDocentes = new Button();
        ButtonPropostasDeDocentes.setText("Assing professors proposals");
        ButtonPropostasDeDocentes.getStyleClass().add("buttonFase2");

        ButtonVoltarFase3 = new Button();
        ButtonVoltarFase3.setText("Back");
        ButtonVoltarFase3.getStyleClass().add("buttonFase2");

        ButtonAtribuirPropostaManualmente = new Button();
        ButtonAtribuirPropostaManualmente.setText("Assign proposal manually");
        ButtonAtribuirPropostaManualmente.getStyleClass().add("buttonFase2");

        ButtonRemoverAtribuicaoPropostaManualmente = new Button();
        ButtonRemoverAtribuicaoPropostaManualmente.setText("Remove proposal manually");
        ButtonRemoverAtribuicaoPropostaManualmente.getStyleClass().add("buttonFase2");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        //gridButtons.add(ButtonAtribuirAutoproposta, 0, 2);
        //gridButtons.add(ButtonPropostasDeDocentes, 0, 4);
        gridButtons.add(ButtonVoltarFase3, 0, 10);
        gridButtons.add(ButtonAtribuirPropostaManualmente, 0, 6);
        gridButtons.add(ButtonRemoverAtribuicaoPropostaManualmente, 0, 4);

        this.setCenter(gridButtons);
    }

}
