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

public class QuadroCandidatura extends BorderPane {
    apoio_poeContext context;
    GridPane grid;

    Label nrPropostasAtribuidas;
    Label nrPropostasNaoAtribuidas;


    public QuadroCandidatura(apoio_poeContext context) {
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

        nrPropostasAtribuidas = new Label("");
        nrPropostasNaoAtribuidas = new Label("");
        int contAtr = 0;
        int contDis = 0;
        for(var p : context.consultaCandidaturas()){
            if(p.getNumero() == 0){
                contDis++;
            }
            else{
                contAtr++;
            }
        }
        nrPropostasAtribuidas.setText("There are " + contAtr + " applications attached to students");
        nrPropostasNaoAtribuidas.setText("There are" + contDis + " not assigned applications");

        grid.add(nrPropostasAtribuidas, 0, 0);
        grid.add(nrPropostasNaoAtribuidas, 0, 1);


        this.setCenter(grid);
    }
}
