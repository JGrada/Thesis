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
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class TRATAMENTO_PROP extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;


    Button ButtonChangeToBase;
    Button ButtonChangeToGestaoManualAtribuicoes;
    Button ButtonAtribuirAutoProposta;
    Button ButtonAtribuirPropostaDeDocente;
    Button ButtonRemoverTodasAsAtribuicoes;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDeAlunos;


    public TRATAMENTO_PROP(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonChangeToBase.setOnAction(ev->context.changeFromTratamentoPropToBase());
        ButtonChangeToGestaoManualAtribuicoes.setOnAction(ev->context.changeToGestaoManualAtribuicoesState());
        ButtonAtribuirAutoProposta.setOnAction(ev->context.atribuirAutoproposta());
        ButtonAtribuirPropostaDeDocente.setOnAction(ev->context.atribuirPropostaDeDocente());
        ButtonRemoverTodasAsAtribuicoes.setOnAction(ev->context.removerTodasAsAtribuicoes());

    }

    public void update(){
        if(context.getState() == apoio_poeState.TRATAMENTO_PROP){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option");

        ButtonChangeToBase = new Button();
        ButtonChangeToBase.setText("Back");
        ButtonChangeToBase.getStyleClass().add("buttonVoltar");

        ButtonChangeToGestaoManualAtribuicoes = new Button();
        ButtonChangeToGestaoManualAtribuicoes.setText("Manual assignment management");
        ButtonChangeToGestaoManualAtribuicoes.getStyleClass().add("buttonFase2");

        ButtonAtribuirAutoProposta = new Button();
        ButtonAtribuirAutoProposta.setText("Assing autoproposal");
        ButtonAtribuirAutoProposta.getStyleClass().add("buttonFase2");

        ButtonAtribuirPropostaDeDocente = new Button();
        ButtonAtribuirPropostaDeDocente.setText("Assign professor proposal");
        ButtonAtribuirPropostaDeDocente.getStyleClass().add("buttonFase2");

        ButtonRemoverTodasAsAtribuicoes = new Button();
        ButtonRemoverTodasAsAtribuicoes.setText("Remove all of the assignments");
        ButtonRemoverTodasAsAtribuicoes.getStyleClass().add("buttonFase2");


        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonChangeToBase, 0, 14);
        gridButtons.add(ButtonChangeToGestaoManualAtribuicoes, 0, 4);
      //  gridButtons.add(ButtonAtribuirAutoProposta, 0, 6);
      //  gridButtons.add(ButtonAtribuirPropostaDeDocente, 0, 8);
        gridButtons.add(ButtonRemoverTodasAsAtribuicoes, 0, 6);
        gridButtons.add(listaDeAlunos, 0, 8);

        this.setCenter(gridButtons);
    }

}
