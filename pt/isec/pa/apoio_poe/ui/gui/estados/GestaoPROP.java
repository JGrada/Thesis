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
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarProposta;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraPropostas;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.InserirProposta;
import pt.isec.pa.apoio_poe.ui.gui.quadros.QuadroPropostas;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaPropostaEditar;
import pt.isec.pa.apoio_poe.ui.gui.remocoes.RemoverProposta;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class GestaoPROP extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmaProposta;
    Button ButtonInserirPropostas;
    Button ButtonRemoverProposta;
    Button ButtonEditarProposta;
    Button ButtonConsultarPropostas;
    Button ButtonConsultarUmaProposta;
    Button ConsultarDadosSobrePropostas;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDePropostas;

    public GestaoPROP(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirPropostas.setOnAction(ev->context.addProposta());
        ButtonInserirUmaProposta.setOnAction(ev->{
            Stage stage = new Stage();
            InserirProposta root = new InserirProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir proposta");
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
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarUmaProposta.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarProposta root = new ConsultarProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Consultar Proposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverProposta.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverProposta root = new RemoverProposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Remover");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonEditarProposta.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaPropostaEditar root = new QuestionaPropostaEditar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Editar");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ConsultarDadosSobrePropostas.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            QuadroPropostas root = new QuadroPropostas(context);
            Scene scene = new Scene(root,200,200);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Consultar");
            stage.setMinWidth(200);
            stage.setMinHeight(200);
            stage.show();
        });
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoPROPtoBase());


    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_PROP){
            this.setVisible(true);
            System.out.println(context.getState() + "LALALALALA");
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        CSSManager.applyCSS(this,"mystyles.css");
        //toolBar = new WindowToolBar(context);
        //toolBar.createViews();


        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option ");

        ButtonInserirPropostas = new Button();
        ButtonInserirPropostas.setText("Insert proposals from a file");
        ButtonInserirPropostas.getStyleClass().add("buttonGestaoPROP");


        ButtonInserirUmaProposta = new Button();
        ButtonInserirUmaProposta.setText("Insert one proposal");
        ButtonInserirUmaProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonConsultarUmaProposta = new Button();
        ButtonConsultarUmaProposta.setText("Consult one proposal");
        ButtonConsultarUmaProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonConsultarPropostas = new Button();
        ButtonConsultarPropostas.setText("Consult every proposal");
        ButtonConsultarPropostas.getStyleClass().add("buttonGestaoPROP");


        ButtonRemoverProposta = new Button();
        ButtonRemoverProposta.setText("Remove proposal");
        ButtonRemoverProposta.getStyleClass().add("buttonGestaoPROP");


        ButtonEditarProposta = new Button();
        ButtonEditarProposta.setText("Edit proposal");
        ButtonEditarProposta.getStyleClass().add("buttonGestaoPROP");


        ConsultarDadosSobrePropostas = new Button();
        ConsultarDadosSobrePropostas.setText("Ver dados sobre propostas");
        ConsultarDadosSobrePropostas.getStyleClass().add("buttonGestaoPROP");


        ButtonVoltar = new Button();
        ButtonVoltar.setText("Back");
        ButtonVoltar.getStyleClass().add("buttonVoltar");


        listaDePropostas = new Label();

        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirPropostas, 0, 2);
        gridButtons.add(ButtonInserirUmaProposta, 0, 4);
        gridButtons.add(ButtonConsultarUmaProposta, 0, 6);
        gridButtons.add(ButtonConsultarPropostas, 0, 8);
        gridButtons.add(ButtonRemoverProposta, 0, 10);
        gridButtons.add(ButtonEditarProposta, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(ConsultarDadosSobrePropostas, 0, 16);
        gridButtons.add(listaDePropostas, 0, 18);

        this.setCenter(gridButtons);
    }

}
