package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraDocente extends BorderPane {
    apoio_poeContext context;
    String email;

    public MostraDocente(apoio_poeContext context, String email) {
        this.context = context;
        this.email = email;
        createViews();
    }

    TableView tableView = new TableView();

    TableColumn<Proposta, String> C1 = new TableColumn<>("Name");
    TableColumn<Proposta, String> C2 = new TableColumn<>("E-mail");
    TableColumn<Proposta, String> C4 = new TableColumn<>("Number of the proposals responsible for");
    TableColumn<Proposta, Integer> C5 = new TableColumn<>("Number of proposals");


    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        C2.setCellValueFactory(new PropertyValueFactory<>("email"));
        C4.setCellValueFactory(new PropertyValueFactory<>("propostaAssociada"));
        C5.setCellValueFactory(new PropertyValueFactory<>("nrDeOrientacoes"));
        tableView.getColumns().addAll(C1, C2, C4, C5);
        tableView.getItems().addAll(context.consultaDocente(email));

        this.setCenter(tableView);

    }
}
