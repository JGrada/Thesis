package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraDocentesComMenosOrientacoes extends BorderPane {
    apoio_poeContext context;

    Label textFieldMedia;
    GridPane grid;

    public MostraDocentesComMenosOrientacoes(apoio_poeContext context) {
        this.context = context;
        createViews();
    }

    private void createViews() {
        textFieldMedia = new Label();
        textFieldMedia.setText(context.consultarDocenteComMenosOrientacoes().getEmail());

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(textFieldMedia, 0, 0);


        this.setCenter(grid);

    }
}
