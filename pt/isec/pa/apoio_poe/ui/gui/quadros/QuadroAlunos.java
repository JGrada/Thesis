package pt.isec.pa.apoio_poe.ui.gui.quadros;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.edicoes.EditarDocente;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuadroAlunos extends BorderPane {
    apoio_poeContext context;
    GridPane grid;

    Label nrAlunosSemProposta;
    Label nrAlunosComProposta;


    public QuadroAlunos(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");


        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        nrAlunosSemProposta = new Label("");
        nrAlunosComProposta = new Label("");
        int contAtr = 0;
        int contDis = 0;
        for(var a : context.consultarAlunos()){
            if(a.getIdPropostaAssociada() == null){
                contAtr++;
            }
            else{
                contDis++;
            }
        }
        nrAlunosSemProposta.setText("There are " + contAtr + " without assigned proposals");
        nrAlunosComProposta.setText("There are " + contDis + " students with availabe proposals");

        grid.add(nrAlunosSemProposta, 0, 0);
        grid.add(nrAlunosComProposta, 0, 1);


        this.setCenter(grid);
    }
}
