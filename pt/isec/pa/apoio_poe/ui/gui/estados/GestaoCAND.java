package pt.isec.pa.apoio_poe.ui.gui.estados;

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
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarCandidatura;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraCandidaturas;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.InserirCandidatura;
import pt.isec.pa.apoio_poe.ui.gui.quadros.QuadroCandidatura;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaCandidaturaAEditar;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaFicheiroCandidaturas;
import pt.isec.pa.apoio_poe.ui.gui.remocoes.RemoverCandidatura;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class GestaoCAND extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;

    Button ButtonAddCandidaturas;
    Button ButtonAddCandidatura;
    Button ButtonConsultaCandidaturas;
    Button ButtonConsultaCandidatura;
    Button ButtonRemoverCandidatura;
    Button ButtonEditarCandidatura;
    Button ConsultarDadosSobreCandidatura;
    Button ButtonExportarCandidaturasParaCsv;


    Button ButtonVoltar;

    Label mensagemEscolha;
    Label listaDeDocentes;

    public GestaoCAND(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonAddCandidaturas.setOnAction(ev->context.addCandidatura());
        ButtonAddCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            InserirCandidatura root = new InserirCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaCandidaturas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraCandidaturas root = new MostraCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarCandidatura root = new ConsultarCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverCandidatura root = new RemoverCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonEditarCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaCandidaturaAEditar root = new QuestionaCandidaturaAEditar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoCANDtoBase());
        ButtonExportarCandidaturasParaCsv.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaFicheiroCandidaturas root = new QuestionaFicheiroCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ConsultarDadosSobreCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            QuadroCandidatura root = new QuadroCandidatura(context);
            Scene scene = new Scene(root,200,200);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Candidatura");
            stage.setMinWidth(200);
            stage.setMinHeight(200);
            stage.show();
        });

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_CAND){
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

        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option ");

        ButtonAddCandidaturas = new Button();
        ButtonAddCandidaturas.setText("Add application from a file");
        ButtonAddCandidaturas.getStyleClass().add("buttonFase2");

        ButtonAddCandidatura = new Button();
        ButtonAddCandidatura.setText("Add application manually");
        ButtonAddCandidatura.getStyleClass().add("buttonFase2");


        ButtonConsultaCandidaturas = new Button();
        ButtonConsultaCandidaturas.setText("View all applications");
        ButtonConsultaCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultaCandidatura = new Button();
        ButtonConsultaCandidatura.setText("View one application");
        ButtonConsultaCandidatura.getStyleClass().add("buttonFase2");

        ButtonRemoverCandidatura = new Button();
        ButtonRemoverCandidatura.setText("Remove application");
        ButtonRemoverCandidatura.getStyleClass().add("buttonFase2");

        ButtonEditarCandidatura = new Button();
        ButtonEditarCandidatura.setText("Edit application");
        ButtonEditarCandidatura.getStyleClass().add("buttonFase2");

        ConsultarDadosSobreCandidatura = new Button();
        ConsultarDadosSobreCandidatura.setText("Data about application");
        ConsultarDadosSobreCandidatura.getStyleClass().add("buttonFase2");


        ButtonExportarCandidaturasParaCsv = new Button();
        ButtonExportarCandidaturasParaCsv.setText("Export applications");
        ButtonExportarCandidaturasParaCsv.getStyleClass().add("buttonFase2");

        ButtonVoltar = new Button();
        ButtonVoltar.setText("Back");
        ButtonVoltar.getStyleClass().add("buttonVoltar");

        listaDeDocentes = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonAddCandidaturas, 0, 2);
        gridButtons.add(ButtonAddCandidatura, 0, 4);
        gridButtons.add(ButtonConsultaCandidaturas, 0, 6);
        gridButtons.add(ButtonConsultaCandidatura, 0, 8);
        gridButtons.add(ButtonRemoverCandidatura, 0, 10);
        gridButtons.add(ButtonEditarCandidatura, 0, 12);
        gridButtons.add(ButtonExportarCandidaturasParaCsv, 0, 14);
        gridButtons.add(ButtonVoltar, 0, 16);
        gridButtons.add(ConsultarDadosSobreCandidatura, 0, 18);

        this.setCenter(gridButtons);
    }

}
