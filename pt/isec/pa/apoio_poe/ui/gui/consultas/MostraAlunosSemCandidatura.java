package pt.isec.pa.apoio_poe.ui.gui.consultas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class MostraAlunosSemCandidatura extends BorderPane {
    apoio_poeContext context;

    public MostraAlunosSemCandidatura(apoio_poeContext context) {
        this.context = context;
        createViews();
    }
    TableView tableView = new TableView();

    TableColumn<Aluno, Long> C1 = new TableColumn<>("Students number");
    TableColumn<Aluno, String> C2 = new TableColumn<>("Name");
    TableColumn<Aluno, String> C3 = new TableColumn<>("Email");
    TableColumn<Aluno, String> C4 = new TableColumn<>("Bachelor");
    TableColumn<Aluno, String> C5 = new TableColumn<>("Area");
    TableColumn<Aluno, Double> C6 = new TableColumn<>("Grade");
    TableColumn<Aluno, Boolean> C7 = new TableColumn<>("Elegibily");
    TableColumn<Aluno, String> C8 = new TableColumn<>("Proposal ID");

    public void createViews(){
        C1.setCellValueFactory(new PropertyValueFactory<>("numero"));
        C2.setCellValueFactory(new PropertyValueFactory<>("nome"));
        C3.setCellValueFactory(new PropertyValueFactory<>("email"));
        C4.setCellValueFactory(new PropertyValueFactory<>("siglaCurso"));
        C5.setCellValueFactory(new PropertyValueFactory<>("siglaRamo"));
        C6.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        C7.setCellValueFactory(new PropertyValueFactory<>("acessoEstagio"));
        C8.setCellValueFactory(new PropertyValueFactory<>("idPropostaAssociada"));
        tableView.getColumns().addAll(C1,C2,C3,C4,C5,C6,C7,C8);
        tableView.getItems().addAll(context.consultarAlunosSemCandidatura());

        this.setCenter(tableView);

    }
}