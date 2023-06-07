package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraCandidatura extends BorderPane {
    apoio_poeContext context;
    long nr;

    public MostraCandidatura(apoio_poeContext context, long nr) {
        this.context = context;
        this.nr = nr;
        createViews();
    }

    TableView tableView = new TableView();

    TableColumn<Proposta, Long> C1 = new TableColumn<>("Student ID");
    TableColumn<Proposta, String> C2 = new TableColumn<>("Proposals");



    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("numero"));
        C2.setCellValueFactory(new PropertyValueFactory<>("arrayCandidaturas"));

        tableView.getColumns().addAll(C1, C2);
        tableView.getItems().addAll(context.consultaCandidatura(nr));

        this.setCenter(tableView);

    }
}
