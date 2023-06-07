package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
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
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE1BLOCK extends BorderPane {


    GridPane gridButtons;

    Button ButtonConsultaAluno;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarDocente;
    Button ButtonConsultarDocentes;
    Button ButtonConsultarProposta;
    Button ButtonConsultarPropostas;

    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;




    public FASE1BLOCK(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonConsultaAluno.setOnAction(ev-> {
            Stage stage = new Stage();
            ConsultarAluno root = new ConsultarAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunos.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunos root = new MostraAlunos(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocente.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarDocente root = new ConsultarDocente(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Docente");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraDocentes root = new MostraDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Docentes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarProposta.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarProposta root = new ConsultarProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Proposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostas root = new MostraPropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Propostas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonSair.setOnAction(ev-> {
            Stage stage = new Stage();
            ConfirmarSaida root = new ConfirmarSaida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Confirmar Saida");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });


    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);

        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        state = new Label();
        state.setText("FASE 1 BLOCK");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option: ");
        mensagemBoasVindas.getStyleClass().add("labelEscolha");

        ButtonConsultaAluno = new Button();
        ButtonConsultaAluno.setText("View one student");
        ButtonConsultaAluno.getStyleClass().add("buttonFase1");

        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("View students");
        ButtonConsultarAlunos.getStyleClass().add("buttonFase1");

        ButtonConsultarDocente = new Button();
        ButtonConsultarDocente.setText("View one professor");
        ButtonConsultarDocente.getStyleClass().add("buttonFase1");

        ButtonConsultarDocentes = new Button();
        ButtonConsultarDocentes.setText("View professors");
        ButtonConsultarDocentes.getStyleClass().add("buttonFase1");

        ButtonConsultarProposta = new Button();
        ButtonConsultarProposta.setText("View one proposal");
        ButtonConsultarProposta.getStyleClass().add("buttonFase1");

        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("View proposals");
        ButtonConsultarPropostas.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Advance to next stage");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonConsultaAluno, 0, 4);
        gridButtons.add(ButtonConsultarAlunos, 0, 6);
        gridButtons.add(ButtonConsultarDocente, 0, 8);
        gridButtons.add(ButtonConsultarDocentes, 0, 10);
        gridButtons.add(ButtonConsultarProposta, 0, 12);
        gridButtons.add(ButtonConsultarPropostas, 0, 14);
        gridButtons.add(ButtonAvancar, 0, 16);
        gridButtons.add(ButtonSair, 0, 18);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE1BLOCKSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
