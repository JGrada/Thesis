package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.estados.*;

import java.net.MalformedURLException;


public class Apoio_poeGUI extends BorderPane {

    private apoio_poeContext fsm;
    private WindowToolBar toolBar;

    public Apoio_poeGUI(apoio_poeContext fsm) throws MalformedURLException {
        this.fsm = fsm;
        createViews();
    }



    public void createViews() throws MalformedURLException {
        StackPane stackPane = new StackPane(new Inicio(fsm), new FASE1(fsm), new GestaoCAND(fsm), new GestaoAL(fsm), new GestaoDOC(fsm), new GestaoPROP(fsm)
        , new FASE2(fsm), new FASE1BLOCK(fsm), new FASE3(fsm), new TRATAMENTO_PROP(fsm), new FASE3MasFASE2Aberta(fsm)
        , new FASE2BLOCK(fsm), new FASE4(fsm), new GESTAO_ORI(fsm), new FASE5(fsm), new FASE3BLOCK(fsm)
        , new GESTAO_MANUAL_ATRIB(fsm));
        this.setTop(new WindowToolBar(fsm));
        this.setCenter(stackPane);
    }
}
