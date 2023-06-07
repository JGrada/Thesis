package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.fsm.FASE1State;
import pt.isec.pa.apoio_poe.model.fsm.IApoio_poeState;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import javax.swing.border.Border;
import java.io.File;
import java.net.MalformedURLException;


public class Inicio extends BorderPane {
    GridPane gridButtons;
    Button ButtonCreateNew;
    Button ButtonLoad;
    Button ButtonSair;
    Label mensagemBoasVindas;
    Label state;
    apoio_poeContext context;


    public Inicio(apoio_poeContext context) throws MalformedURLException {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonCreateNew.setOnAction(ev->{
            if(context.avancarFase() == true);
        });
        ButtonLoad.setOnAction(ev->context.loadState());
        ButtonSair.setOnAction(ev->System.exit(0));
    }

    public void createViews() throws MalformedURLException {
        CSSManager.applyCSS(this,"mystyles.css");

        Image image1 = new Image(new File("/Users/rodrigoalcaide/Desktop/Thesis/ProjetoIntelliJ/pt/isec/pa/apoio_poe/ui/gui/resources/images/uvt.png").toURI().toURL().toExternalForm());

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        state = new Label();
        state.setText(context.getState().toString());

        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Pick an option: ");

        ButtonCreateNew = new Button();
        ButtonCreateNew.setText("Start from beggining");
        ButtonCreateNew.getStyleClass().add("buttonGestaoAL");

        ButtonLoad= new Button();
        ButtonLoad.setText("Load save");
        ButtonLoad.getStyleClass().add("buttonGestaoAL");

        ButtonSair = new Button();
        ButtonSair.setText("Exit");
        ButtonSair.getStyleClass().add("buttonSair");



        gridButtons.add(new ImageView(image1), 0, 0);


        //organizar coordenadas
        //gridButtons.add(state, 0, 0);
        gridButtons.add(mensagemBoasVindas, 0, 2);
        gridButtons.add(ButtonCreateNew, 0, 4);
        gridButtons.add(ButtonLoad, 0, 6);
        gridButtons.add(ButtonSair, 0, 8);
        this.setCenter(gridButtons);
    }

    public void update(){
        if(context.getState() == apoio_poeState.InicioState){
            this.setVisible(true);
        }
        else{
            this.setVisible(false);
        }
    }




}
