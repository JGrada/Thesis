package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.quadros.QuadroPropostas;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaFicheiroAluno;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE3 extends BorderPane {
    GridPane gridButtons;

    Button ButtonTratamentoPro;
    Button ButtonGestaoManualAtribuicoes;
    Button ButtonConsultaAlunosComAutoproposta;
    Button ButtonConsultarAlunosComCandidatura;
    Button ButtonConsultarAlunosComPropostaAtribuida;
    Button ButtonConsultarAlunosSemPropostaAtribuida;
    Button ButtonConsultarListaDeAutopropostas;
    Button ButtonConsultarPropostasDeDocentes;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonConsultaPropostasAtribuidas;
    Button ButtonExportarAlunosCSV;
    Button ButtonAtribuirPropostasAAlunosSemPropostas;

    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonSair;

    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE3(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonTratamentoPro.setOnAction(ev->context.changeToTratamentoProp());
        ButtonAtribuirPropostasAAlunosSemPropostas.setOnAction(ev->context.atribuicaoDeAlunosSemPropostasDefinidas());
        ButtonConsultaAlunosComAutoproposta.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComAutoproposta root = new MostraAlunosComAutoproposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosComCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComCandidatura root = new MostraAlunosComCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosComPropostaAtribuida.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComPropostaAtribuida root = new MostraAlunosComPropostaAtribuida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosSemPropostaAtribuida.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosSemPropostaAtribuida root = new MostraAlunosSemPropostaAtribuida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarListaDeAutopropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaDeAutopropostas root = new MostraListaDeAutopropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of autoproposal");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasDeDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaPropostasDocentes root = new MostraListaPropostasDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of professors proposal");
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
            stage.setTitle("Lista of available proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostasAtribuidas.setOnAction(ev->{
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
        ButtonExportarAlunosCSV.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaFicheiroAluno root = new QuestionaFicheiroAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Export students");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });


        ButtonAvancarFase.setOnAction(ev->context.avancarFase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());

        ButtonSair.setOnAction(ev-> {
            Stage stage = new Stage();
            ConfirmarSaida root = new ConfirmarSaida(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Exit");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });

    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE3){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
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
        state.setText("FASE 3");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option: ");

        ButtonTratamentoPro = new Button();
        ButtonTratamentoPro.setText("Proposals management");
        ButtonTratamentoPro.getStyleClass().add("buttonFase2");

        ButtonAtribuirPropostasAAlunosSemPropostas = new Button();
        ButtonAtribuirPropostasAAlunosSemPropostas.setText("Assign proposals to students without assigned proposals");
        ButtonAtribuirPropostasAAlunosSemPropostas.getStyleClass().add("buttonFase2");

        ButtonGestaoManualAtribuicoes = new Button();
        ButtonGestaoManualAtribuicoes.setText("Assign manually");
        ButtonGestaoManualAtribuicoes.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComPropostaAtribuida = new Button();
        ButtonConsultarAlunosComPropostaAtribuida.setText("View students with autoproposals assigned");
        ButtonConsultarAlunosComPropostaAtribuida.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosSemPropostaAtribuida = new Button();
        ButtonConsultarAlunosSemPropostaAtribuida.setText("View students without autoproposals assigned");
        ButtonConsultarAlunosSemPropostaAtribuida.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("View available proposals");
        ButtonConsultarPropostasDisponiveis.getStyleClass().add("buttonFase2");

        ButtonConsultaPropostasAtribuidas = new Button();
        ButtonConsultaPropostasAtribuidas.setText("View assigned proposals");
        ButtonConsultaPropostasAtribuidas.getStyleClass().add("buttonFase2");

        ButtonExportarAlunosCSV = new Button();
        ButtonExportarAlunosCSV.setText("Export students to CSV");
        ButtonExportarAlunosCSV.getStyleClass().add("buttonFase2");

        ButtonAvancarFase = new Button();
        ButtonAvancarFase.setText("Next stage");
        ButtonAvancarFase.getStyleClass().add("buttonFase2");

        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Previous stage");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Close stage");
        ButtonFecharFase.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonConsultaAlunosComAutoproposta = new Button();
        ButtonConsultaAlunosComAutoproposta.setText("View students with autoproposal");
        ButtonConsultaAlunosComAutoproposta.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComCandidatura = new Button();
        ButtonConsultarAlunosComCandidatura.setText("View students with applications");
        ButtonConsultarAlunosComCandidatura.getStyleClass().add("buttonFase2");

        ButtonConsultarListaDeAutopropostas = new Button();
        ButtonConsultarListaDeAutopropostas.setText("View autoproposals");
        ButtonConsultarListaDeAutopropostas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDeDocentes = new Button();
        ButtonConsultarPropostasDeDocentes.setText("View professors proposals");
        ButtonConsultarPropostasDeDocentes.getStyleClass().add("buttonFase2");


        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonTratamentoPro, 0, 4);
        gridButtons.add(ButtonAtribuirPropostasAAlunosSemPropostas, 0, 6);
        gridButtons.add(ButtonConsultarAlunosComPropostaAtribuida, 0, 8);
        gridButtons.add(ButtonConsultarAlunosSemPropostaAtribuida, 0, 10);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 12);
        gridButtons.add(ButtonConsultaPropostasAtribuidas, 0, 14);
        gridButtons.add(ButtonExportarAlunosCSV, 0, 16);


        gridButtons.add(ButtonAvancarFase, 0, 18);
        gridButtons.add(ButtonRecuarFase, 0, 20);
        gridButtons.add(ButtonFecharFase, 0, 22);
        gridButtons.add(ButtonSair, 0, 24);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridButtons);
        scrollPane.fitToWidthProperty().set(true);


        this.setCenter(scrollPane);
    }






}
