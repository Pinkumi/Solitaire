package com.remonado.solitaire.GUIComponents;

import javafx.scene.layout.Pane;

public abstract class ElementeView extends Pane {

    public ElementeView(){
        this.getStyleClass().addAll("GUIComponents", "Borders");
        setPrefWidth(140);
        setMinHeight(180);

    }

    public abstract void draw();

}
