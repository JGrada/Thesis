package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE3BLOCK extends BorderPane {


    GridPane gridButtons;

    Button ButtonConsultaAlunosComPropostaAtribuida;
    Button ButtonConsultaAlunosSemPropostaAtribuida;
    Button ButtonConsultaAlunosComCandidatura;
    Button ButtonConsultaAlunosSemCandidatura;
    Button ButtonConsultaListaDeAutoPropostas;
    Button ButtonConsultaPropostasDeDocentes;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonPropostasAtribuidas;
    Button ButtonRecuarFaseBlockAnterior;

    Button ButtonSair;
    Button ButtonAvancar;
    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE3BLOCK(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonConsultaAlunosComPropostaAtribuida.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComPropostaAtribuida root = new MostraAlunosComPropostaAtribuida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students with assigned proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosSemPropostaAtribuida.setOnAction(ev-> {
            Stage stage = new Stage();
            MostraAlunosSemPropostaAtribuida root = new MostraAlunosSemPropostaAtribuida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students without assigned proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosComCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComCandidatura root = new MostraAlunosComCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students with application");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosSemCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosSemCandidatura root = new MostraAlunosSemCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students without application");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaListaDeAutoPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaDeAutopropostas root = new MostraListaDeAutopropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of autoproposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostasDeDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaPropostasDocentes root = new MostraListaPropostasDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of professors proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasDisponiveis.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasDisponiveis root = new MostraPropostasDisponiveis(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of available proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonPropostasAtribuidas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasAtribuidas root = new MostraPropostasAtribuidas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of assigned proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonRecuarFaseBlockAnterior.setOnAction(ev->context.changeToFaseBloqueadaAnterior());
        ButtonSair.setOnAction(ev-> {
            Stage stage = new Stage();
            ConfirmarSaida root = new ConfirmarSaida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Confirm exit");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });


    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        toolBar = new WindowToolBar(context);
        toolBar.createViews();
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);

        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        state = new Label();
        state.setText("FASE 3 BLOCK");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option: ");
        mensagemBoasVindas.getStyleClass().add("labelEscolha");

        ButtonPropostasAtribuidas = new Button();
        ButtonPropostasAtribuidas.setText("View assigned proposals");
        ButtonPropostasAtribuidas.getStyleClass().add("buttonFase1");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("View available proposals");
        ButtonConsultarPropostasDisponiveis.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosSemPropostaAtribuida = new Button();
        ButtonConsultaAlunosSemPropostaAtribuida.setText("View students without an assigned proposal");
        ButtonConsultaAlunosSemPropostaAtribuida.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosComPropostaAtribuida = new Button();
        ButtonConsultaAlunosComPropostaAtribuida.setText("View students with an assigned proposal");
        ButtonConsultaAlunosComPropostaAtribuida.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosComCandidatura = new Button();
        ButtonConsultaAlunosComCandidatura.setText("View students with application");
        ButtonConsultaAlunosComCandidatura.getStyleClass().add("buttonFase1");

        ButtonConsultaAlunosSemCandidatura = new Button();
        ButtonConsultaAlunosSemCandidatura.setText("View students without application");
        ButtonConsultaAlunosSemCandidatura.getStyleClass().add("buttonFase1");

        ButtonConsultaListaDeAutoPropostas = new Button();
        ButtonConsultaListaDeAutoPropostas.setText("View autoproposals");
        ButtonConsultaListaDeAutoPropostas.getStyleClass().add("buttonFase1");

        ButtonConsultaPropostasDeDocentes = new Button();
        ButtonConsultaPropostasDeDocentes.setText("View professors proposals");
        ButtonConsultaPropostasDeDocentes.getStyleClass().add("buttonFase1");

        ButtonRecuarFaseBlockAnterior = new Button();
        ButtonRecuarFaseBlockAnterior.setText("Go back to previous blocked stage");
        ButtonRecuarFaseBlockAnterior.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Advance to next stage");
        ButtonAvancar.getStyleClass().add("buttonFase1");


        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonPropostasAtribuidas, 0, 4);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 6);
        gridButtons.add(ButtonConsultaAlunosSemPropostaAtribuida, 0, 8);
        gridButtons.add(ButtonConsultaAlunosComPropostaAtribuida, 0, 10);
        gridButtons.add(ButtonConsultaAlunosComCandidatura, 0, 12);
        gridButtons.add(ButtonConsultaAlunosSemCandidatura, 0, 14);
        gridButtons.add(ButtonConsultaListaDeAutoPropostas, 0, 16);
        gridButtons.add(ButtonConsultaPropostasDeDocentes, 0, 18);
        gridButtons.add(ButtonAvancar, 0, 20);
        gridButtons.add(ButtonRecuarFaseBlockAnterior, 0, 22);
        gridButtons.add(ButtonSair, 0, 24);

        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE3BLOCKSTATE){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
