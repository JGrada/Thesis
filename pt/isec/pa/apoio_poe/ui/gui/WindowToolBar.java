package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.*;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class WindowToolBar extends MenuBar {
    apoio_poeContext context;
    private static final int TOGGLE_SIZE = 40;
    private static final int TOGGLE_IMG_SIZE = TOGGLE_SIZE - 10;
    Menu mnFile;
    MenuItem miNew, miOpen, miSave, miExit;
    Menu mnEdit;
    MenuItem miUndo, miRedo;

    public WindowToolBar(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void createViews(){

        //create menu
        mnFile= new Menu("File");
        //create menu items
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSave = new MenuItem("Save");
        miExit = new MenuItem("Exit");
        //adding items to the menu
        mnFile.getItems().addAll(miNew, miOpen, miSave, new SeparatorMenuItem());

        MenuBar menuBar = new MenuBar(mnFile);
        menuBar.setTranslateX(200);
        menuBar.setTranslateY(20);


        //create menu
        mnEdit = new Menu("Edit");
        //create menu items
        miUndo = new MenuItem("Undo");
        miRedo = new MenuItem("Redo");
        //adding items to the menu
        mnEdit.getItems().addAll(miUndo, miRedo, new SeparatorMenuItem());
        //mnEdit.getM */
        menuBar.getMenus().addAll(mnFile, mnEdit);

        menuBar.setUseSystemMenuBar(true);

        this.getMenus().addAll(mnFile, mnEdit);

    }

    private void registerHandlers() {


        context.addPropertyChangeListener(apoio_poeContext.PROP_FASE, evt -> update());

        mnFile.setOnAction(actionEvent -> {
            update();
        });
        miUndo.setOnAction(actionEvent -> {
            context.undo();
        });
        miRedo.setOnAction(actionEvent -> {
            context.redo();
        });


    }

    public void update(){

    }




}
