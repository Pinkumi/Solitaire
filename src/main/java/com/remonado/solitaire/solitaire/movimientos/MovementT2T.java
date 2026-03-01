package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.TableauDeck;

import java.util.ArrayList;

public class MovementT2T extends Movement{
    private TableauDeck fuente;
    private TableauDeck destino;
    public MovementT2T(TableauDeck fuente, TableauDeck destino) {
        super("T2T");
        this.fuente = fuente;
        this.destino = destino;
    }
    public void undo(){
        ArrayList<CartaInglesa> cards = destino.getUltimasCartas();
        fuente.regresarBloqueDeCartas(cards);
    }

}
