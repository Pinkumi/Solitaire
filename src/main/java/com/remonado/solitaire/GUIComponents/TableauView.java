package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Controller;
import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.TableauDeck;
import javafx.scene.layout.Pane;

public class TableauView extends ElementeView {
    private TableauDeck tDeck;
    private Controller control;
    private int idx;
    public TableauView(TableauDeck tDeck, Controller control, int idx) {
        super();
        this.tDeck = tDeck;
        this.control = control;
        this.idx = idx;

//        setMinWidth(120);
//        setMaxWidth(160);

    }
    public int getIdx() {
        return idx;
    }
    @Override
    public void draw(){
        int initialY = 0;
        int deltaY = 30;
        this.getChildren().clear();
        for(CartaInglesa c : tDeck.getCards()){
            CardView cv = new CardView(c);
//            if(tDeck.getUltimaCarta() == c)cv.setReleased(control);
//            else cv.setDisable(true);
            cv.setReleased(control);
            //cv.setDisable(true);
            cv.setTableauIdx(idx);
            this.getChildren().add(cv);
            cv.setLayoutY(initialY);
            initialY += deltaY;
        }
    }
}
