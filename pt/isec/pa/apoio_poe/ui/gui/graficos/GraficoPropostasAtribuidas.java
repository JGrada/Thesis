package pt.isec.pa.apoio_poe.ui.gui.graficos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class GraficoPropostasAtribuidas extends BorderPane {
    apoio_poeContext context;
    double d;
    Label LabelpropostasAtribuidas;
    Label LabelpropostasDisponiveis;

    public GraficoPropostasAtribuidas(apoio_poeContext context) {
        this.context = context;
        this.d = d;
        createViews();
    }

    public void createViews(){
        System.out.println(d);
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Percentage of assigned proposals");
        stage.setWidth(500);
        stage.setHeight(500);

        double propostasAtribuidas = context.consultarPropostasAtribuidas().size() / (double) context.consultarPropostas().size() * 100;
        double propostasDisponveis = context.consultarPropostasDisponiveis().size() / (double) context.consultarPropostas().size() * 100;
        int propostasDisponveisValor = context.consultarPropostasDisponiveis().size();
        int propostasAtribuidasValor = context.consultarPropostasAtribuidas().size();

        LabelpropostasAtribuidas = new Label("Assigned proposals " + propostasAtribuidasValor + "percentage of" + propostasAtribuidas + "%");
        LabelpropostasDisponiveis = new Label("Availabe proposals " + propostasDisponveisValor + " percentage of" + propostasDisponveis + "%");


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Assigned proposals", propostasAtribuidas),
                        new PieChart.Data("Total of proposals", propostasDisponveis));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Propostas atribuidas/Propostas total");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        //stage.show();
        this.setCenter(new VBox(chart, LabelpropostasAtribuidas, LabelpropostasDisponiveis));
    }

}