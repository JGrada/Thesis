package pt.isec.pa.apoio_poe.ui.gui.graficos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class GraficoPropostasRamos extends BorderPane {
    apoio_poeContext context;
    double d;

    public GraficoPropostasRamos(apoio_poeContext context) {
        this.context = context;
        this.d = d;
        createViews();
    }

    public void createViews(){
        System.out.println(d);
        System.out.println(context.devolveNumPropostasDA()+"DA");
        System.out.println(context.devolveNumPropostasRAS()+"RAS");
        System.out.println(context.devolveNumPropostasSI()+"SI");
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Propostas por ramos");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("PropostasDA", context.devolveNumPropostasDA()),
                        new PieChart.Data("PropostasRAS", context.devolveNumPropostasRAS()),
                        new PieChart.Data("PropostasSI", context.devolveNumPropostasSI()));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Propostas por ramos");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        //stage.show();
        this.setCenter(chart);
    }

}
