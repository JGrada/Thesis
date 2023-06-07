package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraPropostasAtribuidas extends BorderPane {
    apoio_poeContext context;

    public MostraPropostasAtribuidas(apoio_poeContext context) {
        this.context = context;
        createViews();
    }

    TableView tableView = new TableView();

    TableColumn<Proposta, String> C1 = new TableColumn<>("Proposal ID");
    TableColumn<Proposta, Long> C2 = new TableColumn<>("Number of student attached to proposal");
    TableColumn<Proposta, String> C3 = new TableColumn<>("Title");
    TableColumn<Proposta, String> C4 = new TableColumn<>("Type");
    TableColumn<Proposta, Boolean> C5 = new TableColumn<>("Is it assigned");
    TableColumn<Proposta, String> C6 = new TableColumn<>("Professor");

    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("idProposta"));
        C2.setCellValueFactory(new PropertyValueFactory<>("nrAluno"));
        C3.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        C4.setCellValueFactory(new PropertyValueFactory<>("tipoDeProposta"));
        C5.setCellValueFactory(new PropertyValueFactory<>("atribuida"));
        C6.setCellValueFactory(new PropertyValueFactory<>("orientador"));

        tableView.getColumns().addAll(C1,C2,C3,C4,C5,C6);
        tableView.getItems().addAll(context.consultarPropostasAtribuidas());

        this.setCenter(tableView);

    }
}
