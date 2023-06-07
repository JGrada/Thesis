package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraListaDeAutopropostas extends BorderPane {
    apoio_poeContext context;

    public MostraListaDeAutopropostas(apoio_poeContext context) {
        this.context = context;
        createViews();
    }

    TableView tableView = new TableView();

    TableColumn<Proposta, String> C1 = new TableColumn<>("ID proposta");
    TableColumn<Proposta, Long> C2 = new TableColumn<>("nrAluno da proposta");
    TableColumn<Proposta, String> C3 = new TableColumn<>("Titulo da proposta");
    TableColumn<Proposta, String> C4 = new TableColumn<>("Tipo de Proposta");
    TableColumn<Proposta, Boolean> C5 = new TableColumn<>("Atribuida");
    TableColumn<Proposta, String> C6 = new TableColumn<>("Orientador");


    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("idProposta"));
        C2.setCellValueFactory(new PropertyValueFactory<>("nrAluno"));
        C3.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        C4.setCellValueFactory(new PropertyValueFactory<>("tipoDeProposta"));
        C5.setCellValueFactory(new PropertyValueFactory<>("atribuida"));
        C6.setCellValueFactory(new PropertyValueFactory<>("orientador"));

        tableView.getColumns().addAll(C1,C2,C3,C4,C5,C6);
        tableView.getItems().addAll(context.consultarListaDeAutopropostas());

        this.setCenter(tableView);

    }
}
