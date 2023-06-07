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
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarAluno;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraAlunos;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.InserirAluno;
import pt.isec.pa.apoio_poe.ui.gui.quadros.QuadroAlunos;
import pt.isec.pa.apoio_poe.ui.gui.quadros.QuadroPropostas;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaAlunoAEditar;
import pt.isec.pa.apoio_poe.ui.gui.remocoes.RemoverAluno;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class GestaoAL extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmAluno;
    Button ButtonInserirAlunos;
    Button ButtonRemoverAluno;
    Button ButtonEditarAluno;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarUmAluno;
    Button ButtonVoltar;
    Button ConsultarDadosSobreAlunos;
    Label mensagemEscolha;
    Label listaDeAlunos;


    public GestaoAL(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirAlunos.setOnAction(ev->context.addAluno());
        ButtonInserirUmAluno.setOnAction(ev->{
            Stage stage = new Stage();
            InserirAluno root = new InserirAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Register student");
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
            stage.setTitle("Students list");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarUmAluno.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarAluno root = new ConsultarAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.setTitle("Student you are looking for");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverAluno.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverAluno root = new RemoverAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Student removal");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonEditarAluno.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaAlunoAEditar root = new QuestionaAlunoAEditar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Student edit");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ConsultarDadosSobreAlunos.setOnAction(ev->{
            Stage stage = new Stage();
            Stage owner = (Stage) this.getScene().getWindow();
            QuadroAlunos root = new QuadroAlunos(context);
            Scene scene = new Scene(root,200,200);
            stage.initModality(Modality.NONE);
            stage.initOwner(owner);
            stage.setWidth(300);
            stage.setX(owner.getX() - stage.getWidth());
            stage.setY(owner.getY());
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(200);
            stage.setMinHeight(200);
            stage.show();
        });
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoALtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_AL){
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
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Pick an option ");

        ButtonInserirAlunos = new Button();
        ButtonInserirAlunos.setText("Insert students from a file");
        ButtonInserirAlunos.getStyleClass().add("buttonGestaoAL");

        ButtonInserirUmAluno = new Button();
        ButtonInserirUmAluno.setText("Register one student");
        ButtonInserirUmAluno.getStyleClass().add("buttonGestaoAL");

        ButtonConsultarUmAluno = new Button();
        ButtonConsultarUmAluno.setText("Consult one student");
        ButtonConsultarUmAluno.getStyleClass().add("buttonGestaoAL");

        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consult all the students");
        ButtonConsultarAlunos.getStyleClass().add("buttonGestaoAL");

        ButtonRemoverAluno = new Button();
        ButtonRemoverAluno.setText("Remove student");
        ButtonRemoverAluno.getStyleClass().add("buttonGestaoAL");

        ButtonEditarAluno = new Button();
        ButtonEditarAluno.setText("Edit student");
        ButtonEditarAluno.getStyleClass().add("buttonGestaoAL");

        ButtonVoltar = new Button();
        ButtonVoltar.setText("Back");
        ButtonVoltar.getStyleClass().add("buttonVoltar");

        ConsultarDadosSobreAlunos = new Button();
        ConsultarDadosSobreAlunos.setText("View students data");
        ConsultarDadosSobreAlunos.getStyleClass().add("buttonGestaoAL");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirAlunos, 0, 2);
        gridButtons.add(ButtonInserirUmAluno, 0, 4);
        gridButtons.add(ButtonConsultarUmAluno, 0, 6);
        gridButtons.add(ButtonConsultarAlunos, 0, 8);
        gridButtons.add(ButtonRemoverAluno, 0, 10);
        gridButtons.add(ButtonEditarAluno, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(listaDeAlunos, 0, 16);
        gridButtons.add(ConsultarDadosSobreAlunos, 0, 16);

        this.setCenter(gridButtons);
    }

}
