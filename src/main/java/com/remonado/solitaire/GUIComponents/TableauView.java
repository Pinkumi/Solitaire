package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Controller;
import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.TableauDeck;
import javafx.scene.layout.Pane;

public class TableauView extends ElementeView { //hereda de ElementView (clase que agrupa el estilo y el metodo draw())
    private TableauDeck tDeck;
    private Controller control;//recibe el cntroler para mandarlo a la carta
    private int idx;
    public TableauView(TableauDeck tDeck, Controller control, int idx) {
        super();
        this.tDeck = tDeck;
        this.control = control;
        this.idx = idx;
    }
    /**
     * Regresa el valor del índice dentro del tablero
     * @return índice dentro del tablero
     */
    public int getIdx() {
        return idx;
    }
    /**
     * Dibuja las cartas del TableauDeck dentro del ElementView (Pane) y las desplaza un poco hacia abajo
     */
    @Override
    public void draw(){
        int initialY = 0;
        int deltaY = 30;
        this.getChildren().clear();
        for(CartaInglesa c : tDeck.getCards()){
            CardView cv = new CardView(c);
            cv.setReleased(control);
            cv.setTableauIdx(idx);
            this.getChildren().add(cv);
            cv.setLayoutY(initialY);
            initialY += deltaY;
        }
    }
}
