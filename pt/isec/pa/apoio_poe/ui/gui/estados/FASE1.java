package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.ConfirmarSaida;
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE1 extends BorderPane {


    GridPane gridButtons;
    Button ButtonGestaoAlunos;
    Button ButtonGestaoPropostas;
    Button ButtonGestaoDocentes;
    Button ButtonSair;
    Button ButtonAvancar;
    Button ButtonFecharFase;
    Label mensagemBoasVindas;

    Label state;
    apoio_poeContext context;
    WindowToolBar toolBar;




    public FASE1(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonGestaoAlunos.setOnAction(ev->context.changeToGestaoAL());
        ButtonGestaoPropostas.setOnAction(ev->context.changeToPropState());
        ButtonGestaoDocentes.setOnAction(ev->context.changeToGestaoDOC());
        ButtonAvancar.setOnAction(ev->context.avancarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());
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
       // state.setText("FASE 1");

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option ");
        mensagemBoasVindas.getStyleClass().add("labelEscolha");

        ButtonGestaoAlunos = new Button();
        ButtonGestaoAlunos.setText("Students management");
        ButtonGestaoAlunos.getStyleClass().add("buttonFase1");


        ButtonGestaoPropostas= new Button();
        ButtonGestaoPropostas.setText("Thesis proposals management");

        ButtonGestaoPropostas.getStyleClass().add("buttonFase1");

        ButtonGestaoDocentes = new Button();
        ButtonGestaoDocentes.setText("Professors management");

        ButtonGestaoDocentes.getStyleClass().add("buttonFase1");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");

        ButtonAvancar = new Button();
        ButtonAvancar.setText("Next");

        ButtonAvancar.getStyleClass().add("buttonFase1");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Close stage");

        ButtonFecharFase.getStyleClass().add("buttonFecharFase1");

        //organizar coordenadas
        gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonGestaoAlunos, 0, 4);
        gridButtons.add(ButtonGestaoPropostas, 0, 6);
        gridButtons.add(ButtonGestaoDocentes, 0, 8);
        gridButtons.add(ButtonFecharFase, 0, 10);
        gridButtons.add(ButtonAvancar, 0, 12);
        gridButtons.add(ButtonSair, 0, 14);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE1){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }




}
