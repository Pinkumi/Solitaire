package com.remonado.solitaire.GUIComponents;
import com.remonado.solitaire.Controller;
import com.remonado.solitaire.Main;
import com.remonado.solitaire.solitaire.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class SolitaireGUI extends BorderPane {
    private SolitaireGame solitaireGame;
    private Controller control;
    private ArrayList<TableauView> tableauViews;
    private ArrayList<FoundationView> foundationViews;
    private WasteView wasteView;
    private DrawView drawView;
    private Pane  paneMiddle, paneBottom, paneFoundation;
    private BorderPane paneTop;
    private StackPane root;
    private Pane animMask;
    private ImageView undoBttn;
    private Main main;
    public SolitaireGUI(Main main) { //Mando el main (Esta mal) para actualizar con el menu (Lo cambiare para la siguiente practica)
        this.main = main;
        this.getStyleClass().addAll("solitaireBG");
        solitaireGame = new SolitaireGame();
        control =  new Controller(solitaireGame,this);
        tableauViews = new ArrayList<>();
        foundationViews =  new ArrayList<>();
        initializePane();
        wasteView = null;
        drawView = null;
        initializeGUI();
//        animMask = new Pane();
//        animMask.setMouseTransparent(true);
//        this.getChildren().add(animMask);
        setElements();
        addElements();
        drawAll();
    }
    //inicializo los pane para acomodar los elementos graficos
    public void initializePane(){
        paneTop = new BorderPane();
        paneTop.getStyleClass().add("bordersColor");
        paneTop.setMaxWidth(Screen.getPrimary().getBounds().getWidth()-50);
        paneTop.setTranslateX(25);
        paneTop.setTranslateY(10);
        paneMiddle = new Pane();
        paneBottom = new Pane();
        paneFoundation = new Pane();
        undoBttn = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/undo.png"));;
        undoBttn.setFitWidth(75);
        undoBttn.setFitHeight(75);
        //undoBttn.setGraphic(imgUndo);
        undoBttn.getStyleClass().add("menuButton");
    }
    // muestro la pantalla de win (lo cambiare al controller)
    public void gameOver(){
        main.showWin();
    }
    //Funcion falla, explota por sobrecarga de objetos (quizas lo cambie)
    private void playWinAnimation(){ //Funcion falla, explota por sobrecarga de objetos jiji
        for(int i = 0; i < foundationViews.size(); i++){
            FoundationView fv = foundationViews.get(i);
            double x = fv.localToScene(fv.getBoundsInLocal()).getCenterX();
            double y = fv.localToScene(fv.getBoundsInLocal()).getCenterY();
            double velx = 5;
            CardView cv = fv.getLastCard();
            cv.setLayoutX(x);
            cv.setLayoutY(y);
            for(int j =0; j< 100; j++){
                CardView cv1 = new CardView(cv.getCard());
                if(i % 2 == 0) x -= velx; else x += velx;
                velx *= 0.8;
                this.getChildren().add(cv1);
                cv.setLayoutX(x);
                cv.setLayoutY(y);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    /**
     * Redibuja los 2 ultimos elementos graficos que tuvieron interaccion
     *
     * @param gui1 numero indicador de elemento grafico 1;
     * @param gui2 numero indicador de elemento grafico 2;
     */
    public void reDraw(int gui1, int gui2){ //-1 foundation, -2 waste, -3 draw, >0 idx tableau
        if(gui1 == -3 || gui2 == -3) {drawView.draw();wasteView.draw();}
        if(gui1 == -2 || gui2 == -2) wasteView.draw();
        if(gui1 == -1 || gui2 == -1) foundationViews.forEach(FoundationView::draw);
        if(gui1>=0) tableauViews.get(gui1).draw();
        if(gui2>=0) tableauViews.get(gui2).draw();
        //System.out.println(solitaireGame);
    }
    /**
     * Redibuja el tablero entero
     */
    public void drawAll() {
        foundationViews.forEach(FoundationView::draw);
        tableauViews.forEach(TableauView::draw);
        drawView.draw();
        wasteView.draw();
    }
    private void addElements(){
        this.setTop(paneTop);
        this.setCenter(paneMiddle);

    }

    public Pane getPaneFoundation(){
        return paneFoundation;
    }

    /**
     * Agrega los elementos graficos al tablero
     */
    private void setElements() {
        int currentX =  (int)(((2*Screen.getPrimary().getBounds().getWidth())/3)/8 - 200);

        for(FoundationView foundationView : foundationViews){
            foundationView.setLayoutX(currentX);
            foundationView.setLayoutY(20);
            currentX += (int)(((2*Screen.getPrimary().getBounds().getWidth())/3)/4 - (foundationView.getWidth()))-50;
            paneFoundation.getChildren().add(foundationView);
        }
       // paneTop.setRight(paneFoundation);
        currentX = (int)(Screen.getPrimary().getBounds().getWidth()/14 - 60);
        for(TableauView tableau : tableauViews){
            tableau.setLayoutX(currentX);
            tableau.setLayoutY(30);
            currentX += (int)((Screen.getPrimary().getBounds().getWidth())/7 - (tableau.getWidth())) ;
            paneMiddle.getChildren().add(tableau);
        }
        currentX = (int)(Screen.getPrimary().getBounds().getWidth()/3 - 120)+20;
        Pane paneDraw = new Pane();
        drawView.setLayoutX((int)(Screen.getPrimary().getBounds().getWidth()/6 - 140));
        drawView.setLayoutY(20);
        wasteView.setLayoutX(Screen.getPrimary().getBounds().getWidth()/6 + 20);
        wasteView.setLayoutY(20);
        paneDraw.getChildren().add(wasteView);
        paneDraw.getChildren().add(drawView);
        //undoBttn.setLayoutX((int)(Screen.getPrimary().getBounds().getWidth()/6 - 140));
        undoBttn.setLayoutY(50);
        paneDraw.getChildren().add(undoBttn);
        paneTop.getChildren().add(paneDraw);
        paneTop.setPrefHeight(250);
        paneFoundation.setLayoutX((int)(Screen.getPrimary().getBounds().getWidth()/2 - paneFoundation.getWidth()/2));
        paneTop.getChildren().add(paneFoundation);
       // undoBttn.setPrefSize(10,10);
       // paneTop.getChildren().add(undoBttn);
        //currentX = 0;
    }
    /**
     * Inicializa los elementos graficos
     */
    private void initializeGUI() {
        //inicializar las tableau decks
        for(int i = 0; i < solitaireGame.getTableau().size(); i++){
            tableauViews.add(new TableauView(solitaireGame.getTableau().get(i), control,i));
        }
        //inicializar las foundation
        for(int i = 0; i< solitaireGame.getFoundations().size(); i++){
            foundationViews.add(new FoundationView(solitaireGame.getFoundations().get(i), control));

        }
        wasteView = new WasteView(solitaireGame.getWastePile(), control);
        drawView = new DrawView(solitaireGame.getDrawPile(), control);
        drawView.setButton();
        undoBttn.setOnMouseClicked(e -> control.undo());


    }
    public void clearWasteView(){
        wasteView.getChildren().clear();
    }

    public ArrayList<TableauView> getTableauViews() {
        return tableauViews;
    }

}
