package com.remonado.solitaire.GUIComponents;


import com.remonado.solitaire.solitaire.FoundationDeck;
import com.remonado.solitaire.Controller;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FoundationView extends ElementeView {
    private FoundationDeck fDeck;
    private String figura;
   // ArrayList<CardView> cardViews = new ArrayList<>();
    private Controller control;
    public FoundationView(FoundationDeck fDeck, Controller control) {
        figura = fDeck.palo.getFigura();
        super();
        setPrefHeight(200);
        setMinHeight(200);
        setMaxHeight(200);
        this.fDeck = fDeck;
        this.control = control;

    }

    @Override
    public void draw(){
        this.getChildren().clear();
        if(!fDeck.estaVacio()){
            CardView c = new CardView(fDeck.getUltimaCarta());
            c.setDisable(true);
            this.getChildren().addAll(c);
        }else{
            StringBuilder strb = new StringBuilder();
            strb.append("file:src/main/resources/com/remonado/solitaire/Assets/images/");
            switch(figura){
                case "♣\uFE0E":
                    strb.append("trebolPlaceHolder.png");
                    break;
                case "♦\uFE0F":
                    strb.append("diamantePlaceHolder.png");
                    break;
                case "❤\uFE0F":
                    strb.append("corazonPlaceHolder.png");
                    break;
                case "♠\uFE0F":
                    strb.append("picaPlaceHolder.png");
                    break;
            }
            ImageView fondoImg = new ImageView(new Image(strb.toString()));
            fondoImg.setFitWidth(110);
            fondoImg.setPreserveRatio(true);
            fondoImg.setOpacity(0.4);
            fondoImg.setTranslateX(this.getPrefWidth()/2 - fondoImg.getFitWidth()/2);
            fondoImg.setTranslateY(this.getPrefHeight()/7 - fondoImg.getFitHeight());
            this.getChildren().add(fondoImg);
        }


    }
    public CardView getLastCard(){
        return new CardView(fDeck.getUltimaCarta());
    }
}
