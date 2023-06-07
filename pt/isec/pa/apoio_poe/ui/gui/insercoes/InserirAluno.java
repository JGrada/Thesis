package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.avisos.*;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.Objects;

public class InserirAluno extends BorderPane {
     apoio_poeContext context;


    TextField textNr;
    TextField textNome;
    TextField textEmail;
    TextField textSiglaCurso;
    TextField textSiglaRamo;
    TextField textPontuacao;
    TextField textPropostaAssociada;

    CheckBox isAcesso;
    Button buttonConfirm;
    Button buttonClose;


    Label labelNr;
    Label labelNome;
    Label labelEmail;
    Label labelSiglaCurso;
    Label labelSiglaRamo;
    Label labelPontuacao;
    Label labelIDProposta;
    Label labelAcessoEstagio;
    GridPane grid;



    public InserirAluno(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();


    }

    private void registerHandlers(){

        buttonConfirm.setOnAction(ev->{
            boolean existe = false;
            for(int i=0; i<context.consultarAlunos().size(); i++){
                if(context.consultarAlunos().get(i).getNumero() == Long.parseLong(textNr.getText())){
                    existe = true;
                    Stage stage = new Stage();
                    AlunoJaExiste root = new AlunoJaExiste(context);
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Alunos");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
            }
            if(!existe){
                if(Long.parseLong(textNr.getText()) < 200000000){
                    context.addAlunoSingular(new Aluno(Long.parseLong(textNr.getText()), textNome.getText(), textEmail.getText(),
                            textSiglaCurso.getText(), textSiglaRamo.getText(), Double.parseDouble(textPontuacao.getText()),isAcesso.isSelected(), textPropostaAssociada.getText()));


                    Stage stage = new Stage();
                    AlunoInserido root = new AlunoInserido(context);
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Lista de alunos");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
                else{
                    Stage stage = new Stage();
                    NumeroAlunoInvalido root = new NumeroAlunoInvalido(context);
                    Scene scene = new Scene(root,700,400);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Lista de alunos");
                    stage.setMinWidth(700);
                    stage.setMinHeight(400);
                    stage.show();
                    Stage stage1 = (Stage) this.getScene().getWindow();
                    stage1.close();
                }
            }

        });

    }

    private void createViews() {
        CSSManager.applyCSS(this,"mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);



        labelNr = new Label("");
        labelNr.setText("Insert the number of the student you want to add");
        grid.add(labelNr, 0, 0);
        labelNr.getStyleClass().add("labelInsereAluno");

        labelNome = new Label("");
        labelNome.setText("Insert the name of the student you want to add");
        grid.add(labelNome, 0, 3);
        labelNome.getStyleClass().add("labelInsereAluno");

        labelEmail = new Label("");
        labelEmail.setText("Insert the e-mail of the student you want to add");
        grid.add(labelEmail, 0, 6);
        labelEmail.getStyleClass().add("labelInsereAluno");

        labelSiglaCurso = new Label("");
        labelSiglaCurso.setText("Which bachelor is the student studying");
        grid.add(labelSiglaCurso, 0, 9);
        labelSiglaCurso.getStyleClass().add("labelInsereAluno");

        labelSiglaRamo = new Label("");
        labelSiglaRamo.setText("Main preference for the thesis subject");
        grid.add(labelSiglaRamo, 0, 12);
        labelSiglaRamo.getStyleClass().add("labelInsereAluno");

        labelPontuacao = new Label("");
        labelPontuacao.setText("The current average of the students grade");
        grid.add(labelPontuacao, 0, 15);
        labelPontuacao.getStyleClass().add("labelInsereAluno");

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insert the ID of the proposal the student wants to be attached to");
        grid.add(labelIDProposta, 0, 18);
        labelIDProposta.getStyleClass().add("labelInsereAluno");

        labelAcessoEstagio = new Label("");
        labelAcessoEstagio.setText("Is this student eligible for a Thesis project? ");
        grid.add(labelAcessoEstagio, 0, 21);
        labelAcessoEstagio.getStyleClass().add("labelInsereAluno");

        textNr = new TextField("");
        grid.add(textNr, 0, 1);

        textNome = new TextField("");
        grid.add(textNome, 0, 4);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 7);

        textSiglaCurso = new TextField("");
        grid.add(textSiglaCurso, 0, 10);

        textSiglaRamo = new TextField("");
        grid.add(textSiglaRamo, 0, 13);

        textPontuacao = new TextField("");
        grid.add(textPontuacao, 0, 16);

        textPropostaAssociada = new TextField("");
        grid.add(textPropostaAssociada, 0, 19);

        isAcesso = new CheckBox("");
        grid.add(isAcesso, 0, 22);

        buttonConfirm = new Button("Confirm new student");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.fitToWidthProperty().set(true);


        this.setCenter(scrollPane);
    }
}
