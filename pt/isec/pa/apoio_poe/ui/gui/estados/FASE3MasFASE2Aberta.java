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
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraPropostasDisponiveis;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE3MasFASE2Aberta extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;

    Button ButtonRecuarFase;
    Button ButtonChangeToBase;

    Button ButtonSair;
    Label state;
    Button ButtonAtribuirAutoproposta;
    Button ButtonPropostasDeDocentes;

    Button ButtonVoltar;

    Label mensagemEscolha;
    Label listaDeDocentes;

    public FASE3MasFASE2Aberta(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonChangeToBase.setOnAction(ev->context.changeFromF3MasF2AbertaToBase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonAtribuirAutoproposta.setOnAction(ev->context.atribuirAutoproposta());
        ButtonPropostasDeDocentes.setOnAction(ev->context.atribuirPropostaDeDocente());
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

    public void update(){
        if(context.getState() == apoio_poeState.FASE3MasFASE2AbertaState){
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

        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        state = new Label();
        state.setText("FASE 3 Mas Fase 2 Aberta");
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option ");

        ButtonRecuarFase = new Button();
        ButtonRecuarFase.setText("Previous stage");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonChangeToBase = new Button();
        ButtonChangeToBase.setText("Back home");
        ButtonChangeToBase.getStyleClass().add("buttonFase2");

        ButtonAtribuirAutoproposta = new Button();
        ButtonAtribuirAutoproposta.setText("Assign autoproposal");
        ButtonAtribuirAutoproposta.getStyleClass().add("buttonFase2");

        ButtonPropostasDeDocentes = new Button();
        ButtonPropostasDeDocentes.setText("Assign professors proposal");
        ButtonPropostasDeDocentes.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");

        listaDeDocentes = new Label();


        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemEscolha, 0, 2);
        gridButtons.add(ButtonAtribuirAutoproposta, 0, 4);
        gridButtons.add(ButtonPropostasDeDocentes, 0, 6);
        gridButtons.add(ButtonRecuarFase, 0, 8);
        gridButtons.add(ButtonChangeToBase, 0, 10);
        gridButtons.add(ButtonSair, 0, 12);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridButtons);
        scrollPane.fitToWidthProperty().set(true);


        this.setCenter(scrollPane);
    }

}
