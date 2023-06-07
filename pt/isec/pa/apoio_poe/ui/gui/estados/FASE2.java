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
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE2 extends BorderPane {
    GridPane gridButtons;

    Button ButtonGestaoCandidaturas;

    Button ButtonConsultaAlunosComAutoproposta;
    Button ButtonConsultarAlunosComCandidatura;
    Button ButtonConsultarAlunosSemCandidatura;
    Button ButtonConsultarListaDeAutopropostas;
    Button ButtonConsultarPropostasDeDocentes;
    Button ButtonConsultarPropostasComCandidaturas;
    Button ButtonConsultarPropostasSemCandidaturas;
    Button ButtonConsultaPropostas;


    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonSair;

    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE2(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonGestaoCandidaturas.setOnAction(ev->context.changeToGestaoCAND());


        ButtonConsultarAlunosComCandidatura.setOnAction(ev->context.consultarAlunosComCandidatura());
        ButtonConsultarAlunosSemCandidatura.setOnAction(ev->context.consultarAlunosSemCandidatura());
        ButtonConsultarListaDeAutopropostas.setOnAction(ev->{
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
        ButtonConsultarPropostasDeDocentes.setOnAction(ev-> {
            Stage stage = new Stage();
            MostraListaPropostasDocentes root = new MostraListaPropostasDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of professor's proposals");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasComCandidaturas.setOnAction(ev-> {
            Stage stage = new Stage();
            MostraPropostasComCandidaturas root = new MostraPropostasComCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of proposals on applications");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasSemCandidaturas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasSemCandidaturas root = new MostraPropostasSemCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of proposals not on applications");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostas root = new MostraPropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of proposals");
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
            stage.setTitle("List of students with applications");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosSemCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosSemCandidatura root = new MostraAlunosSemCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of students without applications");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosComAutoproposta.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComAutoproposta root = new MostraAlunosComAutoproposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("List of students with autoproposals");
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
            stage.setTitle("Confirm exit");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });




    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE2){
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
        state.setText("FASE 2");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option: ");


        ButtonAvancarFase = new Button();
        ButtonAvancarFase.setText("Advance to next stage");
        ButtonAvancarFase.getStyleClass().add("buttonFase2");

        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Go back to previous stage");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Close stage");
        ButtonFecharFase.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonGestaoCandidaturas = new Button();
        ButtonGestaoCandidaturas.setText("Applications management");
        ButtonGestaoCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultaAlunosComAutoproposta = new Button();
        ButtonConsultaAlunosComAutoproposta.setText("View students with autoproposals");
        ButtonConsultaAlunosComAutoproposta.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComCandidatura = new Button();
        ButtonConsultarAlunosComCandidatura.setText("View students with application");
        ButtonConsultarAlunosComCandidatura.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosSemCandidatura = new Button();
        ButtonConsultarAlunosSemCandidatura.setText("View students without application");
        ButtonConsultarAlunosSemCandidatura.getStyleClass().add("buttonFase2");

        ButtonConsultarListaDeAutopropostas = new Button();
        ButtonConsultarListaDeAutopropostas.setText("View autoproposals");
        ButtonConsultarListaDeAutopropostas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDeDocentes = new Button();
        ButtonConsultarPropostasDeDocentes.setText("View professors proposals");
        ButtonConsultarPropostasDeDocentes.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasComCandidaturas = new Button();
        ButtonConsultarPropostasComCandidaturas.setText("View proposals in applications");
        ButtonConsultarPropostasComCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasSemCandidaturas = new Button();
        ButtonConsultarPropostasSemCandidaturas.setText("View proposals not on applications");
        ButtonConsultarPropostasSemCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultaPropostas = new Button();
        ButtonConsultaPropostas.setText("View proposals");
        ButtonConsultaPropostas.getStyleClass().add("buttonFase2");


        //organizar coordenadas

        gridButtons.add(state, 0, 0);
        //gridButtons.add(ButtonAtribuirPropostasAAlunosSemPropostas, 0,2);
        gridButtons.add(mensagemBoasVindas, 0, 4);
        gridButtons.add(ButtonGestaoCandidaturas, 0, 6);
        gridButtons.add(ButtonConsultarListaDeAutopropostas, 0, 8);
        gridButtons.add(ButtonConsultarPropostasDeDocentes, 0, 10);
        gridButtons.add(ButtonConsultarPropostasComCandidaturas, 0, 12);
        gridButtons.add(ButtonConsultarPropostasSemCandidaturas, 0, 14);
        gridButtons.add(ButtonConsultaPropostas, 0, 16);
        gridButtons.add(ButtonConsultarAlunosComCandidatura, 0, 18);
        gridButtons.add(ButtonConsultarAlunosSemCandidatura, 0, 20);
        gridButtons.add(ButtonConsultaAlunosComAutoproposta, 0, 22);


        gridButtons.add(ButtonFecharFase, 0, 24);
        gridButtons.add(ButtonRecuarFase, 0, 26);
        gridButtons.add(ButtonAvancarFase, 0, 28);
        gridButtons.add(ButtonSair, 0, 30);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridButtons);
        scrollPane.fitToWidthProperty().set(true);



        this.setCenter(scrollPane);
    }






}
