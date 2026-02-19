package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Controller;
import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.DrawPile;
import com.remonado.solitaire.solitaire.TableauDeck;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawView extends StackPane {
    private DrawPile dPile;
   // Controller controller;
    private Controller control;
    public DrawView(DrawPile drawPile, Controller control) {
        this.dPile = drawPile;
        //this.controller = controller;
        this.control = control;
        setPrefHeight(190);
        setMinHeight(190);
        setMaxHeight(190);
        this.getStyleClass().addAll("GUIComponents", "Borders");
        this.getStyleClass().addAll("card");

    }
    public void setButton() {
        setOnMouseClicked(e -> control.drawCard());
    }

    public void draw(){
        this.getChildren().clear();
        if(dPile.hayCartas()){
            ImageView imv = new ImageView();
            imv.setImage(new Image("file:src/main/resources/com/remonado/solitaire/Assets/images/trasera.png"));
            Rectangle clip = new Rectangle(imv.getImage().getWidth(), imv.getImage().getHeight());
            clip.setArcHeight(15);
            clip.setArcWidth(15);
            clip.setStroke(Color.BLACK);
            imv.setClip(clip);
            SnapshotParameters prm = new SnapshotParameters();
            prm.setFill(Color.TRANSPARENT);
            WritableImage image = imv.snapshot(prm, null);
            imv.setClip(null);
            imv.setImage(image);
            imv.setFitWidth(135);
            imv.setPreserveRatio(true);
            this.getChildren().add(imv);
        }else{
            ImageView imv = new ImageView();
            imv.setImage(new Image("file:src/main/resources/com/remonado/solitaire/Assets/images/reload.png"));
            imv.setFitWidth(135);
            imv.setPreserveRatio(true);
            this.getChildren().add(imv);

        }
    }
}
