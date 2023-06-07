package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class ConsultarOrientacaoDeDocente extends BorderPane {
    apoio_poeContext context;

    Label textOrientacoes;
    String email;
    GridPane grid;

    public ConsultarOrientacaoDeDocente(apoio_poeContext context, String email ) {
        this.context = context;
        this.email = email;
        createViews();
    }

    private void createViews() {
        textOrientacoes = new Label();
        textOrientacoes.setText(context.consultarOrientacoesDocente(email));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(textOrientacoes, 0, 0);


        this.setCenter(grid);

    }
}
