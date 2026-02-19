package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Controller;
import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.WastePile;
import javafx.scene.layout.Pane;

public class WasteView extends ElementeView {
    private WastePile wastePile;
    private Controller control;
    public WasteView(WastePile wastePile, Controller control ) {
        super();
        setPrefHeight(180);
        setMaxHeight(180);
        this.wastePile = wastePile;
        this.control = control;
    }

    @Override
    public void draw(){
        CartaInglesa regresar = wastePile.verCarta();
        this.getChildren().clear();
        if(regresar!=null) {
            CardView c = new CardView(regresar);
            c.setReleased(control);
            this.getChildren().add(c);
        }
    }

}
