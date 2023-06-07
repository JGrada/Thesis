package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraDocentes extends BorderPane {
    apoio_poeContext context;

    public MostraDocentes(apoio_poeContext context) {
        this.context = context;
        createViews();
    }

    TableView tableView = new TableView();

    TableColumn<Proposta, String> C1 = new TableColumn<>("Nome do docente");
    TableColumn<Proposta, String> C2 = new TableColumn<>("Email do docente");
    TableColumn<Proposta, String> C3 = new TableColumn<>("Funcao do projeto");
    TableColumn<Proposta, String> C4 = new TableColumn<>("Proposta associada");
    TableColumn<Proposta, Integer> C5 = new TableColumn<>("Numero de Orientacoes");


    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        C2.setCellValueFactory(new PropertyValueFactory<>("email"));
        C3.setCellValueFactory(new PropertyValueFactory<>("funcaoProjeto"));
        C4.setCellValueFactory(new PropertyValueFactory<>("propostaAssociada"));
        C5.setCellValueFactory(new PropertyValueFactory<>("nrDeOrientacoes"));


        tableView.getColumns().addAll(C1,C2,C3,C4,C5);
        tableView.getItems().addAll(context.consultaDocentes());

        this.setCenter(tableView);

    }
}
